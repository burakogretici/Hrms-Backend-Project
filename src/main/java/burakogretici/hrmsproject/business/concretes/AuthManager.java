package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.*;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.entities.concretes.User;
import burakogretici.hrmsproject.core.utilities.business.BusinessRules;
import burakogretici.hrmsproject.core.utilities.results.*;
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
        Employer employer = Employer.builder()
                .companyName(employerForRegisterDto.getCompanyName())
                .phone(employerForRegisterDto.getPhone())
                .email(employerForRegisterDto.getEmail())
                .webSite(employerForRegisterDto.getWebsite())
                .password(employerForRegisterDto.getPassword())
                .confirmPassword(employerForRegisterDto.getConfirmPassword())
                .build();

        var result = employerService.add(employer);
        if (result.isSuccess()) {
            return new SuccessDataResult<Employer>(employer, Messages.employerRegistered);
        }
        return new ErrorDataResult<>();
    }

    @Override
    public DataResult<JobSeeker> jobSeekerRegister(JobSeekerForRegisterDto jobSeekerForRegisterDto) {

        JobSeeker jobSeeker = JobSeeker.builder()
                .email(jobSeekerForRegisterDto.getEmail())
                .firstName(jobSeekerForRegisterDto.getFirstName())
                .lastName(jobSeekerForRegisterDto.getLastName())
                .dateOfBirth(jobSeekerForRegisterDto.getDate_of_birth())
                .nationalityId(jobSeekerForRegisterDto.getNationalityId())
                .password(jobSeekerForRegisterDto.getPassword())
                .confirmPassword(jobSeekerForRegisterDto.getConfirmPassword())
                .build();
        jobSeekerService.add(jobSeeker);
        return new SuccessDataResult<>(jobSeeker, Messages.jobSeekerRegistered);
    }

    @Override
    public DataResult<User> login(LoginForDto loginForDto) {
        var userToCheck = userService.getByMail(loginForDto.getEmail());
        if (userToCheck == null) {
            return new ErrorDataResult<>(Messages.userNotFound);
        }
        return new SuccessDataResult<User>(Messages.userLogin);
    }

    @Override
    public Result userExists(String mail) {
        if (userService.getByMail(mail).isSuccess()) {
            return new SuccessResult();
        }
        return new ErrorResult(Messages.userAlreadyExists);
    }
}
