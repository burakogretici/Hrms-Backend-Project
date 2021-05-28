package burakogretici.hrmsproject.dataAccess.abstracts;

import burakogretici.hrmsproject.entities.concretes.JobAdvertisement;
import burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface JobAdvertisementDao  extends JpaRepository<JobAdvertisement, Integer> {

    List<JobAdvertisement> getAllByEmployer_EmployerId(int employerId);
    List<JobAdvertisementDto> getAllByReleaseDate(LocalDate date);

}

