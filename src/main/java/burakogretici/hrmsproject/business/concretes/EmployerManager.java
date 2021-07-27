package burakogretici.hrmsproject.business.concretes;

import java.util.List;
import java.util.Optional;

import burakogretici.hrmsproject.business.abstracts.EmailActivationService;
import burakogretici.hrmsproject.business.abstracts.EmployeeVerificationService;
import burakogretici.hrmsproject.core.utilities.business.BusinessRules;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.EmployerUpdateDao;
import burakogretici.hrmsproject.entities.concretes.EmployeeVerification;
import burakogretici.hrmsproject.entities.concretes.EmployerUpdate;
import burakogretici.hrmsproject.entities.dtos.EmployerForUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import burakogretici.hrmsproject.business.conctants.Messages;

import burakogretici.hrmsproject.business.abstracts.EmployerService;
import burakogretici.hrmsproject.dataAccess.abstracts.EmployerDao;
import burakogretici.hrmsproject.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailActivationService emailActivationService;
    private EmployeeVerificationService employeeVerificationService;
    private EmployerUpdateDao employerUpdateDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailActivationService emailActivationService, EmployeeVerificationService employeeVerificationService, EmployerUpdateDao employerUpdateDao) {
        super();
        this.employerDao = employerDao;
        this.emailActivationService = emailActivationService;
        this.employeeVerificationService = employeeVerificationService;
        this.employerUpdateDao = employerUpdateDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.employerListed);
    }

    @Override
    public Result add(Employer employer) {
        Result result = BusinessRules.run(emailExits(employer.getEmail()), doNotMach(employer), passwordMatch(employer.getPassword(), employer.getConfirmPassword()));
        if (result != null) {
            return result;
        }
        this.employerDao.save(employer);
        this.emailActivationService.createAndSendActivationCodeByMail(employer, employer.getEmail());
        employeeVerificationService.add(EmployeeVerification.builder().user(employer).build());

        return new SuccessResult(Messages.employerAdded);
    }

    @Override
    public Result update(Employer employer) {
        employerDao.save(employer);
        return new SuccessResult(Messages.employerUpdated);
    }

    @Override
    public DataResult<Employer> getById(int id) {
        Optional<Employer> employer = employerDao.findById(id);
        return new SuccessDataResult<Employer>(Messages.employerListed);
    }

    @Override
    public DataResult<EmployerUpdate> getLastUpdateByUserId(int employerId) {
        List<EmployerUpdate> employerUpdates = employerUpdateDao.findAllByEmployer_IdOrderByUpdatedAtDesc(employerId);

        if (employerUpdates.size() == 0)
            return new ErrorDataResult<>(Messages.pendingUpdateApproval);

        return new SuccessDataResult<EmployerUpdate>(employerUpdates.get(0));
    }

    @Override
    public DataResult<List<EmployerUpdate>> getAllByIsApprovedAndIsDeleted(boolean isApproved, boolean isDeleted) {
        List<EmployerUpdate> employerUpdates = employerUpdateDao.findAllByIsApprovedAndIsDeleted(isApproved, isDeleted);

        return new SuccessDataResult<List<EmployerUpdate>>(employerUpdates);
    }

    @Override
    public Result updateByUser(EmployerForUpdateDto employerForUpdateDto) {
        Optional<Employer> employer = employerDao.findById(employerForUpdateDto.getId());
        if (employer.isEmpty())
            return new ErrorResult(Messages.employeeVerificationNotFound);

        Result businessRulesResult = BusinessRules.run(passwordMatch(employer.get().getPassword(), employerForUpdateDto.getPassword()));
        if (!businessRulesResult.isSuccess())
            return businessRulesResult;

        EmployerUpdate employerUpdate = EmployerUpdate.builder()
                .employer(employer.get())
                .companyName(employerForUpdateDto.getCompanyName())
                .webSite(employerForUpdateDto.getWebsite())
                .email(employerForUpdateDto.getEmail())
                .phone(employerForUpdateDto.getPhone())
                .build();
        employerUpdateDao.save(employerUpdate);

        return new SuccessResult(Messages.employerUpdated);
    }

    @Override
    public Result verifyUpdate(int employerUpdateId) {
        Optional<EmployerUpdate> employerUpdate = employerUpdateDao.findById(employerUpdateId);
        if (employerUpdate.isEmpty())
            return new ErrorResult(Messages.employerNotFound);
        employerUpdate.get().setApproved(true);
        employerUpdate.get().setDeleted(true);
        employerUpdateDao.save(employerUpdate.get());

        /*Employer employer = super.getById(employerUpdate.get().getEmployer().getId()).getData();
        employer.setCompanyName(employerUpdate.get().getCompanyName());
        employer.setWebSite(employerUpdate.get().getWebSite());
        employer.setEmail(employerUpdate.get().getEmail());
        employer.setPhone(employerUpdate.get().getPhone());
        super.update(employer);*/

        return new SuccessResult(Messages.employerUpdated);
    }

    private Result emailExits(String email) {
        var result = employerDao.findAll().stream().anyMatch(e -> e.getEmail().equals(email));
        if (result) {
            return new ErrorResult(Messages.mailAlreadyRegistered);
        }
        return new SuccessResult();
    }

    private Result doNotMach(Employer employer) {
        String email = employer.getEmail();
        String webSite = employer.getWebSite();

        String domain = webSite.split("www.")[1];
        if (domain.equals(email.split("@")[1])) {
            return new SuccessResult();
        }
        return new ErrorResult(Messages.doNotMatch);
    }

    private Result passwordMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword) ? new SuccessResult()
                : new ErrorResult(Messages.passwordMatch);
    }


}
