package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.ForeignLanguageService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.ForeignLanguageDao;
import burakogretici.hrmsproject.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {


    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }


    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult(Messages.foreignLanguageAdded);
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {

        return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll());

    }

    @Override
    public DataResult<List<ForeignLanguage>> getAllByCv_Id(int cvId) {
        List<ForeignLanguage> foreignLanguages = foreignLanguageDao.findAllByCv_Id(cvId);
        if (foreignLanguages == null) {
            return new ErrorDataResult<>();
        }
        return new SuccessDataResult<List<ForeignLanguage>>(foreignLanguages);
    }
}
