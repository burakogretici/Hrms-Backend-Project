package burakogretici.hrmsproject.dataAccess.abstracts;

import burakogretici.hrmsproject.entities.concretes.FavoriteJobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FavoriteJobAdvertDao extends JpaRepository<FavoriteJobAdvert, Integer> {

}
