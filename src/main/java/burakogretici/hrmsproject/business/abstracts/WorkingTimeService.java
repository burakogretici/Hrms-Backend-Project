package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.WorkingTime;

import java.util.List;

public interface WorkingTimeService {

    Result add(WorkingTime workingTime);

    DataResult<List<WorkingTime>> getAll();
}
