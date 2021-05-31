package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.JobAdvertisementService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.JobAdvertisementDao;
import burakogretici.hrmsproject.entities.concretes.JobAdvertisement;
import burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



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
    public Result closeByPostingId(int id) {
        Optional<JobAdvertisement> jobAdvertisement = jobAdvertisementDao.findById(id);
        if (jobAdvertisement.isEmpty())

            return new ErrorDataResult<JobAdvertisement>(Messages.JobPostingNotFound);

        jobAdvertisement.get().setActive(false);

        return update(jobAdvertisement.get());
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

    @Override
    public DataResult<List<JobAdvertisementDto>> getAllByIsActiveOrderByCreatedDate(boolean isActive, String sort) {
        List<JobAdvertisementDto> jobAdvertisementDtos = sort.equals("desc")
                ? jobAdvertisementDao.findAllByIsActiveOrderByCreationDateDesc(isActive)
                : jobAdvertisementDao.findAllByIsActiveOrderByCreationDateAsc(isActive);

        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDtos);
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        jobAdvertisementDao.save(jobAdvertisement);

        return new SuccessResult(Messages.JobPostingUpdated);
    }
}
