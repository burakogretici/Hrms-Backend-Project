package burakogretici.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.utilities.results.SuccessDataResult;
import burakogretici.hrmsproject.core.utilities.results.SuccessResult;

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
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),Messages.employerListed);
    }

    @Override
    public Result add(Employer employer) {
         this.employerDao.save(employer);
        return new SuccessResult(Messages.employerAdded);
    }

}
