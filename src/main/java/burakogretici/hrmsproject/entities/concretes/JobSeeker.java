package burakogretici.hrmsproject.entities.concretes;

import burakogretici.hrmsproject.core.entities.concretes.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_seekers")
public class JobSeeker extends User {

    @NotEmpty(message = "First name cannot be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Nationality id cannot be empty")
    @Column(name = "nationality_id")
    private String nationalityId;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

}