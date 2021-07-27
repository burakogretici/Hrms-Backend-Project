package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.EmailActivationService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.entities.concretes.User;
import burakogretici.hrmsproject.core.utilities.helper.EmailService;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.EmailActivationDao;
import burakogretici.hrmsproject.entities.concretes.EmailActivation;
import burakogretici.hrmsproject.entities.dtos.EmailActivationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class EmailActivationManager implements EmailActivationService {

    private EmailActivationDao emailActivationDao;
    private EmailService emailService;

    @Autowired
    public EmailActivationManager(EmailActivationDao emailActivationDao,  EmailService emailService) {
        this.emailActivationDao = emailActivationDao;
        this.emailService = emailService;
    }

    @Override
    public Result add(EmailActivation emailActivation) {
        emailActivationDao.save(emailActivation);
        return new SuccessResult(Messages.emailActivationAdded);
    }

    @Override
    public DataResult<List<EmailActivation>> getAll() {
       var result = emailActivationDao.findAll();
       return new SuccessDataResult<List<EmailActivation>>(result);
    }

    @Override
    public DataResult<EmailActivation> getById(int id) {
        var result = emailActivationDao.findById(id);

        if (result.isEmpty())
            return new ErrorDataResult(Messages.emailActivationNotFound);

        return new SuccessDataResult(result.get());
    }

    @Override
    public Result createAndSendActivationCodeByMail(User user, String... emails) {
        for (String email : emails) {
            EmailActivation emailActivation = EmailActivation.builder()
                    .user(user)
                    .email(email)
                    .activationCode("EmailActivationCodeTEST")
                    .expirationDate(LocalDateTime.now().plusMonths(1))
                    .build();
            emailActivationDao.save(emailActivation);
            emailService.send(email,
                    Messages.emailActivationVerifyEmailTitle,
                    String.format("%swww.localhost:8080/api/emailactivations/verify?activationCode=%s&email=%s",
                            Messages.emailActivationVerifyEmailBody,
                            emailActivation.getActivationCode(),
                            email));
        }

        return new SuccessResult(Messages.emailActivationCreatedAndSent);
    }
    @Override
    public Result update(EmailActivation emailActivation) {
        emailActivationDao.save(emailActivation);
        return new SuccessResult(Messages.emailActivationUpdated);
    }

    @Override
    public Result verify(EmailActivationDto emailActivationDto) {
         Optional<EmailActivation> emailActivation = emailActivationDao.findByEmailAndActivationCode(
                emailActivationDto.getEmail(),
                emailActivationDto.getActivationCode());

        if (emailActivation.isEmpty())
            return new ErrorResult(Messages.emailNotVerified);

        emailActivation.get().setActivated(true);
        emailActivationDao.save(emailActivation.get());

        return new SuccessResult(Messages.emailVerified);
    }
}
