package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.entities.concretes.User;
import burakogretici.hrmsproject.core.utilities.results.Result;

public interface MailVerificationService {
    Result validMail(User user);
}
