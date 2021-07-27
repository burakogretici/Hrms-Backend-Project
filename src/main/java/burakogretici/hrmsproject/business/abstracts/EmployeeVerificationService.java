package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.EmployeeVerification;

import java.util.List;

public interface EmployeeVerificationService {
    Result add(EmployeeVerification employeeVerification);

    DataResult<List<EmployeeVerification>> getAll();

    DataResult<EmployeeVerification> getByUserId(int userId);

    Result verify(int id);


}
