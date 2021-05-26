package burakogretici.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakogretici.hrmsproject.entities.concretes.JobSeeker;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerDao  extends JpaRepository<JobSeeker, Integer>{

}

