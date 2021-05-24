package burakogretici.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.utilities.results.SuccessDataResult;
import burakogretici.hrmsproject.core.utilities.results.SuccessResult;

import burakogretici.hrmsproject.business.abstracts.JobSeekerService;
import burakogretici.hrmsproject.dataAccess.abstracts.JobSeekerDao;
import burakogretici.hrmsproject.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        super();
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),Messages.departmentListed) ;
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult(Messages.jobSeekerAdded);
    }

}
