package burakogretici.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakogretici.hrmsproject.entities.concretes.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao  extends JpaRepository<Employee, Integer>{

}
