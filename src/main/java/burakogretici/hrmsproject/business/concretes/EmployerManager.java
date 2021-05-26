package burakogretici.hrmsproject.business.concretes;

import java.util.List;

import burakogretici.hrmsproject.core.utilities.business.BusinessRules;
import burakogretici.hrmsproject.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import burakogretici.hrmsproject.business.conctants.Messages;

import burakogretici.hrmsproject.business.abstracts.EmployerService;
import burakogretici.hrmsproject.dataAccess.abstracts.EmployerDao;
import burakogretici.hrmsproject.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        super();
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.employerListed);
    }

    @Override
    public Result add(Employer employer) {
        Result result = BusinessRules.run(emailExits(employer.getEmail()),doNotMach(employer));
        if (!result.equals(null)) {
            return result;
        }
        this.employerDao.save(employer);
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
        String[] emailSplit = email.split("@");
        if(!emailSplit[1].equals(employer.getWebSite())) {
            return new ErrorResult(Messages.doNotMatch);
        }
        return new SuccessResult();
    }
}

