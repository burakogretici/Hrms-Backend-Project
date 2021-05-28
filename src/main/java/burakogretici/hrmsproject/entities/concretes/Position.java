package burakogretici.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty(message="name cannot be empty")
    @Column(name="title")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<JobAdvertisement> jobAdvertisements;
}
