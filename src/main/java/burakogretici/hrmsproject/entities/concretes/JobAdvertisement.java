package burakogretici.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    //@NotEmpty(message = " City cannot be empty")
    //@Column(name="city_id")
    //private integer cityId;

    @NotEmpty(message = "Description cannot be empty")
    @Column(name="description")
    private String description;

    @NotEmpty(message = "Min salary  cannot be empty")
    @Column(name="min_salary")
    private String minSalary;

    @NotEmpty(message = "Max salary  cannot be empty")
    @Column(name="max_salary")
    private String maxSalary;

    @NotEmpty(message = " Quantity cannot be empty")
    @Column(name="request_quantity")
    private String quantity;


    @Column(name="creation_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    //@NotEmpty(message = "Deadline cannot be empty")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @Column(name = "is_active")
    private boolean isActive;

    //Join transaction
    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
