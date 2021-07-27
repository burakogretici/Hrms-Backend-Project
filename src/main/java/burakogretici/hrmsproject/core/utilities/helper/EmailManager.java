package burakogretici.hrmsproject.core.utilities.helper;

import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {
    @Override
    public Result send(String to, String title, String body) {
        return new SuccessResult("Email has send.");
    }
}
