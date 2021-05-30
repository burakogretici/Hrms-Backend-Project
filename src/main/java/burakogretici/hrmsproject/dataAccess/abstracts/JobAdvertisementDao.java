package burakogretici.hrmsproject.dataAccess.abstracts;

import burakogretici.hrmsproject.entities.concretes.JobAdvertisement;
import burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    @Query("SELECT new burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto(e.companyName,p.name,j.quantity,j.creationDate,j.deadline) FROM JobAdvertisement j JOIN j.employer e JOIN j.position p WHERE j.isActive=:isActive AND e.companyName=:companyName")
    List<JobAdvertisementDto> findAllByIsActiveAndEmployer_CompanyName(@Param("isActive") boolean isActive,
                                                                       @Param("companyName") String companyName);

    @Query("SELECT new burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto(e.companyName,p.name,j.quantity,j.creationDate,j.deadline) FROM JobAdvertisement j JOIN j.employer e JOIN j.position p WHERE j.isActive=:isActive")
    List<JobAdvertisementDto> findAllByIsActive(@Param("isActive") boolean isActive);

    @Query("SELECT new burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto(e.companyName,p.name,j.quantity,j.creationDate,j.deadline) FROM JobAdvertisement j JOIN j.employer e JOIN j.position p WHERE j.isActive=:isActive order by j.creationDate desc" )
    List<JobAdvertisementDto> findAllByIsActiveOrderByCreationDateDesc(@Param("isActive") boolean isActive);

    @Query("SELECT new burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto(e.companyName,p.name,j.quantity,j.creationDate,j.deadline) FROM JobAdvertisement j JOIN j.employer e JOIN j.position p WHERE j.isActive=:isActive order by j.creationDate asc" )
    List<JobAdvertisementDto> findAllByIsActiveOrderByCreationDateAsc(@Param("isActive") boolean isActive);
}

