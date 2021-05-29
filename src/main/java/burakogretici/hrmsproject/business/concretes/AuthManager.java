package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.*;
import burakogretici.hrmsproject.core.entities.concretes.User;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Employer;
import burakogretici.hrmsproject.entities.concretes.JobSeeker;
import burakogretici.hrmsproject.entities.dtos.EmployerForRegisterDto;
import burakogretici.hrmsproject.entities.dtos.JobSeekerForRegisterDto;
import burakogretici.hrmsproject.entities.dtos.LoginForDto;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    private UserService userService;
    private UserCheckService userCheckService;
    private EmployerService employerService;
    private JobSeekerService jobSeekerService;

    public AuthManager(UserService userService, UserCheckService userCheckService, EmployerService employerService, JobSeekerService jobSeekerService) {
        this.userService = userService;
        this.userCheckService = userCheckService;
        this.employerService = employerService;
        this.jobSeekerService = jobSeekerService;
    }

    @Override
    public DataResult<Employer> employerRegister(EmployerForRegisterDto employerForRegisterDto) {
        return null;

    }
    @Override
    public DataResult<JobSeeker> jobSeekerRegister(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
        return null;

    }

    @Override
    public DataResult<User> login(LoginForDto loginForDto) {
        return null;
    }
}
