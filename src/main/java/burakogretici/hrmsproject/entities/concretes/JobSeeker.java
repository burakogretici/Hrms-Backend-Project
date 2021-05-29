package burakogretici.hrmsproject.entities.concretes;

import burakogretici.hrmsproject.core.entities.concretes.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers")
public class JobSeeker extends User {

    @NotEmpty(message = "First name cannot be empty")
    @Column(name="first_name")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Column(name="last_name")
    private String lastName;

    @NotEmpty(message = "Nationality id cannot be empty")
    @Column(name="nationality_id")
    private String nationalityId;

    @NotEmpty(message = " Date or Birth cannot be empty")
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name="date_of_birth")
    private String dateOfBirth;

}