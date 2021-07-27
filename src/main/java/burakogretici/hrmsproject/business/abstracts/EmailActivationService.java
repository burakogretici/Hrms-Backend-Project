package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.entities.concretes.User;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.EmailActivation;
import burakogretici.hrmsproject.entities.dtos.EmailActivationDto;

import java.util.List;

public interface EmailActivationService {
    Result add(EmailActivation emailActivation);

    Result update(EmailActivation emailActivation);

    DataResult<List<EmailActivation>> getAll();

    DataResult<EmailActivation> getById(int id);

    Result createAndSendActivationCodeByMail(User user, String... emails);

    Result verify(EmailActivationDto emailActivationDto);
}
