package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.JobAdvertisementService;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.JobAdvertisement;
import burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        return null;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return null;
    }

    @Override
    public DataResult<JobAdvertisementDto> getByAllRelaseDate(LocalDate date) {
        return null;
    }

    @Override
    public DataResult<JobAdvertisement> getByAllByEmployerId(int employerId) {
        return null;
    }
}
