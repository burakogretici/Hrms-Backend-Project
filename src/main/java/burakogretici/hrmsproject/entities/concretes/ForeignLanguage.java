package burakogretici.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
@Table(name = "foreign_languages")
public class ForeignLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @JoinColumn(name = "cv_id")
    @ManyToOne
    private Cv cv;

    @NotEmpty(message = "Tongue cannot be empty")
    @Column(name = "tongue")
    private String tongue;

    @Min(1)
    @Max(5)
    @Column(name = "level")
    private int level;

}
