package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.ExperienceService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.ExperienceDao;
import burakogretici.hrmsproject.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {


    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }


    @Override
    public Result add(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult(Messages.experienceAdded);

    }

    @Override
    public DataResult<List<Experience>> getAll() {

        return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll());
    }

    @Override
    public DataResult<List<Experience>> getAllByCv_Id(int cvId) {
        List<Experience> experiences = experienceDao.findAllByCv_Id(cvId);
        if (experiences == null) {
            return new ErrorDataResult<>();
        }
        return new SuccessDataResult<List<Experience>>(experiences);
    }

    @Override
    public DataResult<List<Experience>> getAllByCv_IOrderByEndDate(int cvId, String direction) {
        List<Experience> experiences = direction.equals("desc")
                ? experienceDao.findAllByCv_IdOrderByEndDateDesc(cvId)
                : experienceDao.findAllByCv_IdOrderByEndDate(cvId);

        return new SuccessDataResult<List<Experience>>(experiences);
    }
}
