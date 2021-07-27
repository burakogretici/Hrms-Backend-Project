package burakogretici.hrmsproject.core.utilities.helper;

import burakogretici.hrmsproject.core.utilities.results.Result;

public interface EmailService {
    Result send(String to, String title, String body);
}
