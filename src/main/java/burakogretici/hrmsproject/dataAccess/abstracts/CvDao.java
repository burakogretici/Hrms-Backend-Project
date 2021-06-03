package burakogretici.hrmsproject.dataAccess.abstracts;

import burakogretici.hrmsproject.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvDao extends JpaRepository<Cv, Integer> {
    List<Cv> findByJobSeeker_Id(int jobSeekerId);
}
