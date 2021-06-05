package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.entities.concretes.User;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Employer;
import burakogretici.hrmsproject.entities.concretes.JobSeeker;
import burakogretici.hrmsproject.entities.dtos.EmployerForRegisterDto;
import burakogretici.hrmsproject.entities.dtos.JobSeekerForRegisterDto;
import burakogretici.hrmsproject.entities.dtos.LoginForDto;

public interface AuthService {
    DataResult<Employer> employerRegister(EmployerForRegisterDto employerForRegisterDto);

    DataResult<JobSeeker> jobSeekerRegister(JobSeekerForRegisterDto jobSeekerForRegisterDto);

    DataResult<User> login(LoginForDto loginForDto);

    Result userExists(String mail);

}
