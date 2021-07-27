package burakogretici.hrmsproject.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"jobSeeker", "foreignLanguage", "experience", "talent"})
@EqualsAndHashCode
@Table(name = "cvs")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @JsonIgnore()
    @OneToMany(mappedBy = "cv")
    private List<Education> educations;

    @JsonIgnore()
    @OneToMany(mappedBy = "cv")
    private List<ForeignLanguage> foreignLanguages;

    @JsonIgnore()
    @OneToMany(mappedBy = "cv")
    private List<Experience> experiences;

    @JsonIgnore()
    @OneToMany(mappedBy = "cv")
    private List<Talent> talents;

    @JsonIgnore()
    @OneToMany(mappedBy = "cv")
    private List<Photo> photos;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "about")
    private String about;

}



