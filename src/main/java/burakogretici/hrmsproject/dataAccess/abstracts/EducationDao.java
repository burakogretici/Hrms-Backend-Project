package burakogretici.hrmsproject.dataAccess.abstracts;

import burakogretici.hrmsproject.entities.concretes.Education;
import burakogretici.hrmsproject.entities.concretes.Experience;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationDao extends JpaRepository<Education, Integer> {
    List<Education> findAllByCv_Id(int cvId);

    List<Education> findAllByCv_IdOrderByEndYear(int cvId);

    @Query("select e.startingYear,e.endYear from Education e ")
    List<Education> findAllByCv_IdOrderByEndYearDesc(int cvId);

}
