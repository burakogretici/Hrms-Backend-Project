package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.MailVerificationService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.entities.concretes.User;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class MailVerificationManager implements MailVerificationService {

    @Override
    public Result validMail(User user) {
        return new SuccessResult(Messages.userVerified);
    }
}
