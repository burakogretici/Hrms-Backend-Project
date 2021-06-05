package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.UserService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.UserDao;
import burakogretici.hrmsproject.core.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult(Messages.userAdded);
    }

    @Override
    public DataResult<User> getByMail(String mail) {
        var result = userDao.findByEmail(mail);
        if (result.isEmpty()){
        return new ErrorDataResult<User>(Messages.userNotFound);
        }
        return new SuccessDataResult<User>();
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(userDao.findAll(),Messages.userListed);
    }


}

