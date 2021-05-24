package burakogretici.hrmsproject.business.abstracts;

import java.util.List;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Department;

public interface DepartmentService {

    Result add(Department department);
    DataResult<List<Department>> getAll();

}
