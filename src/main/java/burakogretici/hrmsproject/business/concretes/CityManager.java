package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.CityService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.business.BusinessRules;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.CityDao;
import burakogretici.hrmsproject.dataAccess.abstracts.DepartmentDao;
import burakogretici.hrmsproject.entities.concretes.City;
import burakogretici.hrmsproject.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {


    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        super();
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
       var result=BusinessRules.run(cityAlreadyExists(city));
       if (result != null){
          return result;
       }
        this.cityDao.save(city);
        return new SuccessResult(Messages.cityAdded);
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(), Messages.cityListed);
    }
    private Result cityAlreadyExists(City city) {
        var result = city.getName();
        if (result == null) {
            return new SuccessResult();
        }
        return new ErrorResult(Messages.cityAlreadyExists);
    }
}
