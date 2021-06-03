package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.CvService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.CvDao;
import burakogretici.hrmsproject.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;

    @Autowired
    public CvManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }


    @Override
    public Result add(Cv cv) {

        this.cvDao.save(cv);
        return new SuccessResult(Messages.cvAdded);
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
    }

    @Override
    public DataResult<List<Cv>> getByJobSeeker_Id(int jobSeekerId) {
        List<Cv> cvs = cvDao.findByJobSeeker_Id(jobSeekerId);
        if (cvs == null) {
            return new ErrorDataResult<>(Messages.cvNotFound);
        }
        return new SuccessDataResult<List<Cv>>();
    }
}

