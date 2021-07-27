package burakogretici.hrmsproject.business.concretes;

import burakogretici.hrmsproject.business.abstracts.EmployeeVerificationService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.*;
import burakogretici.hrmsproject.dataAccess.abstracts.EmployeeVerificationDao;
import burakogretici.hrmsproject.entities.concretes.EmployeeVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeVerificationManager implements EmployeeVerificationService {
    private EmployeeVerificationDao employeeVerificationDao;

    @Autowired
    public EmployeeVerificationManager(EmployeeVerificationDao employeeVerificationDao) {
        this.employeeVerificationDao = employeeVerificationDao;
    }


    @Override
    public Result add(EmployeeVerification employeeVerification) {
        employeeVerificationDao.save(employeeVerification);

        return new SuccessResult(Messages.employeeVerificationAdded);
    }

    @Override
    public DataResult<List<EmployeeVerification>> getAll() {
        var result = employeeVerificationDao.findAll();
        return new SuccessDataResult<List<EmployeeVerification>>(result);
    }

    @Override
    public DataResult<EmployeeVerification> getByUserId(int userId) {
        var result = employeeVerificationDao.findByUser_Id(userId);

        if (result.isEmpty()) {
            return new ErrorDataResult<EmployeeVerification>(Messages.employeeVerificationNotFound);
        }
        return new SuccessDataResult(result);

    }

    @Override
    public Result verify(int id) {
        var result = getByUserId(id);

        if (!result.isSuccess())
            return new ErrorResult(Messages.employeeVerificationNotFound);

        result.getData().setApproved(true);
        employeeVerificationDao.save(result.getData());

        return new SuccessResult(Messages.employeeVerificationVerified);
    }
}

