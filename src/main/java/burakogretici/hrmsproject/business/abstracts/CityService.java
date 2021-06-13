package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.City;

import java.util.List;

public interface CityService {
    Result add(City city);

    DataResult<List<City>> getAll();
}
