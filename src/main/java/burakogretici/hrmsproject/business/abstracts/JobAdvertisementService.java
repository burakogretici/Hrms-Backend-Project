package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.JobAdvertisement;
import burakogretici.hrmsproject.entities.concretes.Talent;
import burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);

    Result update(JobAdvertisement jobAdvertisement);

    Result closeByPostingId(int id);

    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> getById(int jobAdvertId);

    DataResult<List<JobAdvertisementDto>> getAllByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName);

    DataResult<List<JobAdvertisementDto>> getAllByIsActive(boolean isActive);

    DataResult<List<JobAdvertisementDto>> getAllByIsActiveOrderByCreatedDate(boolean isActive, String sort);

}
