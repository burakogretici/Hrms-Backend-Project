package burakogretici.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "experiences")
public class Experience {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Company cannot be empty")
    @Column(name = "company")
    private String companyName;

    @NotEmpty(message = "Position cannot be empty")
    @Column(name = "position")
    private String position;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
    @Column(name = "starting_date")
    private Date startingDate;

    @Value("${some.key:continues}")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
    @Column(name = "end_date")
    private Date endDate;

    @OneToMany(mappedBy = "experience")
    private List<Cv> cv;
}
