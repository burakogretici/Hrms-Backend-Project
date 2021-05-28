package burakogretici.hrmsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_postings")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    //@NotEmpty(message = "Employer id cannot be empty")
    //@Column(name="employer_id")
    //private int employerId;

    //@NotEmpty(message = "Position id cannot be empty")
    //@Column(name="position_id")
    //private int positionId;

    @NotEmpty(message = "Description cannot be empty")
    @Column(name="description")
    private String description;

    @NotEmpty(message = " City cannot be empty")
    @Column(name="city")
    private String city;

    @NotEmpty(message = "Salary  cannot be empty")
    @Column(name="salary")
    private String salary;

    @NotEmpty(message = " Quantity cannot be empty")
    @Column(name="request_quantity")
    private String quantity;

    @NotEmpty(message = "Deadline cannot be empty")
    @Column(name="application_deadline")
    private Date deadline;


    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;


}
