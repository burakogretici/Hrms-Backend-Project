package burakogretici.hrmsproject.business.concretes;

import java.util.List;

import burakogretici.hrmsproject.business.abstracts.EmailActivationService;
import burakogretici.hrmsproject.business.abstracts.UserCheckService;
import burakogretici.hrmsproject.core.utilities.business.BusinessRules;
import burakogretici.hrmsproject.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import burakogretici.hrmsproject.business.conctants.Messages;

import burakogretici.hrmsproject.business.abstracts.JobSeekerService;
import burakogretici.hrmsproject.dataAccess.abstracts.JobSeekerDao;
import burakogretici.hrmsproject.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private UserCheckService userCheckService;
    private EmailActivationService emailActivationService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserCheckService userCheckService, EmailActivationService emailActivationService) {
        super();
        this.jobSeekerDao = jobSeekerDao;
        this.userCheckService = userCheckService;
        this.emailActivationService = emailActivationService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), Messages.jobSeekerListed);
    }

    @Override
    public Result add(JobSeeker jobSeeker) {

        Result result = BusinessRules.run(nationalityIdExits(jobSeeker.getNationalityId()), emailExits(jobSeeker.getEmail()), passwordMatch(jobSeeker));
        if (!userCheckService.CheckIfRealPerson(jobSeeker)) {
            return new ErrorResult(Messages.verificationFailed);

        } else if (result != null) {
            return result;
        }

        this.jobSeekerDao.save(jobSeeker);
        this.emailActivationService.createAndSendActivationCodeByMail(jobSeeker, jobSeeker.getEmail());
        return new SuccessResult(Messages.jobSeekerAdded);

    }

    private Result nationalityIdExits(String nationalityId) {
        var result = jobSeekerDao.findAll().stream().anyMatch(j -> j.getNationalityId().equals(nationalityId));
        if (result) {
            return new ErrorResult(Messages.nationalityIdAlreadyRegistered);
        }
        return new SuccessResult();
    }

    private Result emailExits(String email) {
        var result = jobSeekerDao.findAll().stream().anyMatch(j -> j.getEmail().equals(email));
        if (result) {
            return new ErrorResult(Messages.mailAlreadyRegistered);
        }
        return new SuccessResult();
    }

    private Result passwordMatch(JobSeeker jobSeeker) {
        var result = jobSeeker.getPassword().equals(jobSeeker.getConfirmPassword());
        if (result) {
            return new SuccessResult();
        }
        return new ErrorResult(Messages.passwordMatch);
    }
}

