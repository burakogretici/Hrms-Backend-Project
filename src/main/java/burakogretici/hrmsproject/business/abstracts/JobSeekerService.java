package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.entities.concretes.FavoriteJobAdvert;
import burakogretici.hrmsproject.entities.concretes.JobSeeker;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;

import java.util.List;

public interface JobSeekerService {

    DataResult<List<JobSeeker>> getAll();

    Result add(JobSeeker jobSeeker);

}