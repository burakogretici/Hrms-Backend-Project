package burakogretici.hrmsproject.business.concretes;

import java.util.List;

import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.utilities.results.SuccessDataResult;
import burakogretici.hrmsproject.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakogretici.hrmsproject.business.abstracts.DepartmentService;
import burakogretici.hrmsproject.dataAccess.abstracts.DepartmentDao;
import burakogretici.hrmsproject.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentDao departmanDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmanDao) {
        super();
        this.departmanDao = departmanDao;
    }

    @Override
    public Result add(Department department) {
        this.departmanDao.save(department);
        return new SuccessResult(Messages.departmentAdded);
    }

    @Override
    public DataResult<List<Department>> getAll() {

        return new SuccessDataResult<List<Department>>(this.departmanDao.findAll(),Messages.departmentListed) ;
    }

}
