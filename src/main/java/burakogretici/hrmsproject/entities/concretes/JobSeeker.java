package burakogretici.hrmsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Job_Sekers")
public class JobSeeker extends User{

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
    @Column(name="date_of_birth")
    private String dateOfBirth;

}