package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Education;

import java.util.List;

public interface EducationService {

    Result add(Education education);

    DataResult<List<Education>> getAll();

    DataResult<List<Education>> getAllByCv_Id(int cvId);

    DataResult<List<Education>> getAllByCv_IdOrderByEndYear(int cvId, String direction);
}
