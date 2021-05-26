package burakogretici.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakogretici.hrmsproject.entities.concretes.Position;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionDao  extends JpaRepository<Position, Integer> {

}
