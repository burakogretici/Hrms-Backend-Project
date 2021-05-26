package burakogretici.hrmsproject.business.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.User;

import java.util.List;

public interface UserService {
    Result add(User user);
    DataResult<List<User>> getAll();

}
