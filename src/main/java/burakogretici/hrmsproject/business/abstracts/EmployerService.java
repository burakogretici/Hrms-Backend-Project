package burakogretici.hrmsproject.business.abstracts;

import java.util.List;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Employer;
import burakogretici.hrmsproject.entities.concretes.EmployerUpdate;
import burakogretici.hrmsproject.entities.concretes.JobSeeker;
import burakogretici.hrmsproject.entities.dtos.EmployerForUpdateDto;

import javax.xml.crypto.Data;

public interface EmployerService {

    Result add(Employer employer);

    Result update(Employer employer);

    DataResult<List<Employer>> getAll();

    DataResult<Employer> getById(int id);

    DataResult<EmployerUpdate> getLastUpdateByUserId(int employerId);

    DataResult<List<EmployerUpdate>> getAllByIsApprovedAndIsDeleted(boolean isApproved, boolean isDeleted);

    Result updateByUser(EmployerForUpdateDto employerForUpdateDto);

    Result verifyUpdate(int employerUpdateId);

}