package burakogretici.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakogretici.hrmsproject.entities.concretes.Department;


public interface DepartmentDao  extends JpaRepository<Department, Integer> {

}
