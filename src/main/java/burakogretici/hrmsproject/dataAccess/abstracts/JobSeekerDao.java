package burakogretici.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakogretici.hrmsproject.entities.concretes.JobSeeker;


public interface JobSeekerDao  extends JpaRepository<JobSeeker, Integer>{


}

