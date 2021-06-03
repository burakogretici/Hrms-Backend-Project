package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.TalentService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.TalentDao;
import burakogretici.hrmsproject.entities.concretes.Experience;
import burakogretici.hrmsproject.entities.concretes.ForeignLanguage;
import burakogretici.hrmsproject.entities.concretes.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentManager implements TalentService {


    private TalentDao talentDao;

    @Autowired
    public TalentManager(TalentDao talentDao) {
        this.talentDao = talentDao;
    }


    @Override
    public Result add(Talent talent) {
        this.talentDao.save(talent);
        return new SuccessResult(Messages.talentAdded);
    }

    @Override
    public DataResult<List<Talent>> getAll() {

        return new SuccessDataResult<List<Talent>>(this.talentDao.findAll());

    }

    @Override
    public DataResult<List<Talent>> getAllByCv_Id(int cvId) {
        List<Talent> talents = talentDao.findAllByCv_Id(cvId);
        if (talents == null) {
            return new ErrorDataResult<>();
        }
        return new SuccessDataResult<List<Talent>>(talents);
    }
}
