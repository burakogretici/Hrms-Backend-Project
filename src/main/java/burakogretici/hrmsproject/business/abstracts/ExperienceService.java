package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {

    Result add(Experience experience);

    DataResult<List<Experience>> getAll();

    DataResult<List<Experience>> getAllByCv_Id(int cvId);

    DataResult<List<Experience>> getAllByCv_IOrderByEndDate(int cvId, String direction);
}
