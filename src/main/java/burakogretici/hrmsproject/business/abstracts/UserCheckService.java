package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.entities.concretes.JobSeeker;

public interface UserCheckService {

    boolean CheckIfRealPerson(JobSeeker jobSeeker);
}
