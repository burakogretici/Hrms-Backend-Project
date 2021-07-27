package burakogretici.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteJobAdvert extends JpaRepository<FavoriteJobAdvert, Integer> {
    List<FavoriteJobAdvert> findByJobSeeker_IdAndJobAdvert_Id(int jobSeekerId, int jobAdvertId);
}
