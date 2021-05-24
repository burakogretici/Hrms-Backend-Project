package burakogretici.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.utilities.results.SuccessDataResult;
import burakogretici.hrmsproject.core.utilities.results.SuccessResult;

import burakogretici.hrmsproject.business.abstracts.PositionService;
import burakogretici.hrmsproject.dataAccess.abstracts.PositionDao;
import burakogretici.hrmsproject.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

    private PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        super();
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<List<Position>>(this.positionDao.findAll(),Messages.positionListed);
    }

    @Override
    public Result add(Position position) {
        this.positionDao.save(position);
        return new SuccessResult(Messages.positionAdded);

    }
}
