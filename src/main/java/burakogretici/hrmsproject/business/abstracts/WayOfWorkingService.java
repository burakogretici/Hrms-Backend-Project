package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.WayOfWorking;

import java.util.List;

public interface WayOfWorkingService {

    Result add(WayOfWorking wayOfWorking);

    DataResult<List<WayOfWorking>> getAll();
}
