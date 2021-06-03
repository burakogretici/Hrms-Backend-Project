package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.EducationService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.EducationDao;
import burakogretici.hrmsproject.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Result add(Education education) {
        //Business Rules
        this.educationDao.save(education);
        return new SuccessResult(Messages.educationAdded);
    }

    @Override
    public DataResult<List<Education>> getAll() {

      return new SuccessDataResult<List<Education>>(this.educationDao.findAll());
    }

    @Override
    public DataResult<List<Education>> getAllByCv_Id(int cvId) {
        List<Education> educations = educationDao.findAllByCv_Id(cvId);
        if (educations == null){
            return new ErrorDataResult<>();
        }
        return new SuccessDataResult<List<Education>>(educations);
    }

    @Override
    public DataResult<List<Education>> getAllByCv_IdOrderByEndYear(int cvId, String direction) {
        List<Education> educations = direction.equals("desc")
       ?educationDao.findAllByCv_IdOrderByEndYearDesc(cvId)
       :educationDao.findAllByCv_IdOrderByEndYear(cvId);
        return new SuccessDataResult<List<Education>>(educations);
    }
}
