package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.WorkingTimeService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.utilities.results.SuccessDataResult;
import burakogretici.hrmsproject.core.utilities.results.SuccessResult;
import burakogretici.hrmsproject.dataAccess.abstracts.WayOfWorkingDao;
import burakogretici.hrmsproject.dataAccess.abstracts.WorkingTimeDao;
import burakogretici.hrmsproject.entities.concretes.WayOfWorking;
import burakogretici.hrmsproject.entities.concretes.WorkingTime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeManager implements WorkingTimeService {

    private WorkingTimeDao workingTimeDao;

    public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
        super();
        this.workingTimeDao = workingTimeDao;
    }




    @Override
    public Result add(WorkingTime workingTime) {
        workingTimeDao.save(workingTime);
        return new SuccessResult(Messages.workingTimeAdded);
    }

    @Override
    public DataResult<List<WorkingTime>> getAll() {
        return new SuccessDataResult<List<WorkingTime>>(workingTimeDao.findAll(),Messages.workingTimeListed);
    }
}
