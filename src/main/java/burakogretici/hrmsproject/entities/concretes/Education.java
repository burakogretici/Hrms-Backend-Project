package burakogretici.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @JoinColumn(name = "cv_id")
    @ManyToOne
    private Cv cv;

    @NotEmpty(message = "School name cannot be empty")
    @Column(name = "school_name")
    private String schoolName;

    @NotEmpty(message = "Episode cannot be empty")
    @Column(name = "episode")
    private String episode;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    @Column(name = "starting_year")
    private Date startingYear;

    @Value("${some.key:continues}")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    @Column(name = "end_year")
    private Date endYear;


}
