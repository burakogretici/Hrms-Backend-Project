package burakogretici.hrmsproject.entities.concretes;


import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"jobSeeker", "education", "foreignLanguage", "experience", "talent"})
@EqualsAndHashCode
@Table(name = "cvs")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;


    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;


    @ManyToOne
    @JoinColumn(name = "foreign_language_id")
    private ForeignLanguage foreignLanguage;


    @ManyToOne
    @JoinColumn(name = "experience_id")
    private Experience experience;


    @ManyToOne
    @JoinColumn(name = "talent_id")
    private Talent talent;


    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "about")
    private String about;

}



