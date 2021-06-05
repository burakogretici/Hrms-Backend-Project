package burakogretici.hrmsproject.entities.concretes;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;



import java.util.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_postings")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Description cannot be empty")
    @Column(name = "description")
    private String description;

    @NotEmpty(message = "Min salary  cannot be empty")
    @Column(name = "min_salary")
    private String minSalary;

    @NotEmpty(message = "Max salary  cannot be empty")
    @Column(name = "max_salary")
    private String maxSalary;

    @NotEmpty(message = " Quantity cannot be empty")
    @Column(name = "request_quantity")
    private int quantity;

    @CreationTimestamp
    @Column(name = "creation_date")
    private Date creationDate;

    @NotEmpty(message = "Deadline cannot be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "application_deadline")
    private Date deadline;

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