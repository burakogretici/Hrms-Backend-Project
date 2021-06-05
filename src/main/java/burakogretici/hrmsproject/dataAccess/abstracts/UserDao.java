package burakogretici.hrmsproject.dataAccess.abstracts;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;

import burakogretici.hrmsproject.core.entities.concretes.User;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findByEmail(String mail);
}

