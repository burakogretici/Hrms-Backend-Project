package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.dataAccess.abstracts.JobAdvertisementDao;
import burakogretici.hrmsproject.entities.concretes.JobAdvertisement;
import burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisementDto>> getAllByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName);

    DataResult<List<JobAdvertisementDto>> getAllByIsActive(boolean isActive);

}
