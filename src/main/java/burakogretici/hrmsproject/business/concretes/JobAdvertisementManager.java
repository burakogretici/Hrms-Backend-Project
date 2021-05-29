package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.JobAdvertisementService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.utilities.results.SuccessDataResult;
import burakogretici.hrmsproject.core.utilities.results.SuccessResult;
import burakogretici.hrmsproject.dataAccess.abstracts.JobAdvertisementDao;
import burakogretici.hrmsproject.entities.concretes.JobAdvertisement;
import burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }


    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.jobPostingAdded);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<>(this.jobAdvertisementDao.findAll(), Messages.jobPostingsListed);
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getAllByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName) {
         List<JobAdvertisementDto> jobAdvertisementsDtos = jobAdvertisementDao.findAllByIsActiveAndEmployer_CompanyName(isActive, companyName);

        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementsDtos);
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getAllByIsActive(boolean isActive) {
        List<JobAdvertisementDto> jobAdvertisementsDtos = jobAdvertisementDao.findAllByIsActive(isActive);

        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementsDtos);
    }

}
