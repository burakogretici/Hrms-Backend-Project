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


    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailActivationService emailActivationService, EmployeeVerificationService employeeVerificationService) {
        super();
        this.employerDao = employerDao;
        this.emailActivationService = emailActivationService;
        this.employeeVerificationService = employeeVerificationService;

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
