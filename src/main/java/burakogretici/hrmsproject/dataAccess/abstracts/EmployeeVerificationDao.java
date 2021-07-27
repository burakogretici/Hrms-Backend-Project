package burakogretici.hrmsproject.dataAccess.abstracts;

import burakogretici.hrmsproject.entities.concretes.EmployeeVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeVerificationDao extends JpaRepository<EmployeeVerification, Integer> {
    List<EmployeeVerification> findByUser_Id(int userId);
}
