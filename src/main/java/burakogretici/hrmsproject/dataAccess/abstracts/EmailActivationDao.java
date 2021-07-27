package burakogretici.hrmsproject.dataAccess.abstracts;

import burakogretici.hrmsproject.entities.concretes.EmailActivation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmailActivationDao extends JpaRepository<EmailActivation,Integer> {
    Optional<EmailActivation> findByEmailAndActivationCode(String email, String activationCode);
}
