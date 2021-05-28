package burakogretici.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakogretici.hrmsproject.core.entities.concretes.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}

