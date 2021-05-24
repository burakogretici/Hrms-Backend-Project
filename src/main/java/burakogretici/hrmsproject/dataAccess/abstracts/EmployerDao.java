package burakogretici.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakogretici.hrmsproject.entities.concretes.Employer;


public interface EmployerDao  extends JpaRepository<Employer, Integer>{

}

