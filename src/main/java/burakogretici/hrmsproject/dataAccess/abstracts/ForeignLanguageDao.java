package burakogretici.hrmsproject.dataAccess.abstracts;

import burakogretici.hrmsproject.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {
    List<ForeignLanguage> findAllByCv_Id(int cvId);

}
