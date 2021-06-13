package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.WayOfWorkingService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.WayOfWorkingDao;
import burakogretici.hrmsproject.entities.concretes.WayOfWorking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayOfWorkingManager implements WayOfWorkingService {

    private WayOfWorkingDao wayOfWorkingDao;

    public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao) {
        super();
        this.wayOfWorkingDao = wayOfWorkingDao;
    }


    @Override
    public Result add(WayOfWorking wayOfWorking) {
        wayOfWorkingDao.save(wayOfWorking);
        return new SuccessResult(Messages.wayOfWorkingAdded);
    }

    @Override
    public DataResult<List<WayOfWorking>> getAll() {
        return new SuccessDataResult<List<WayOfWorking>>(wayOfWorkingDao.findAll(),Messages.wayOfWorkingListed);
    }
}

