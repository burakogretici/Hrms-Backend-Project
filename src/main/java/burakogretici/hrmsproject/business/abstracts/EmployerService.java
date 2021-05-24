package burakogretici.hrmsproject.business.abstracts;

import java.util.List;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Employer;

import javax.xml.crypto.Data;

public interface EmployerService {

    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
}