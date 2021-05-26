package burakogretici.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakogretici.hrmsproject.entities.concretes.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao  extends JpaRepository<Department, Integer> {

}
