package burakogretici.hrmsproject.dataAccess.abstracts;

import burakogretici.hrmsproject.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceDao extends JpaRepository<Experience, Integer> {

    List<Experience> findAllByCv_Id(int experienceId);

    List<Experience> findAllByCv_IdOrderByEndDate(int cvId);

    List<Experience> findAllByCv_IdOrderByEndDateDesc(int cvId);
}
