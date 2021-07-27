package burakogretici.hrmsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "favorite_job_adverts")
public class FavoriteJobAdvert {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @JoinColumn(name = "job_seeker_id")
    @ManyToOne
    private JobSeeker jobSeeker;

    @NotNull
    @JoinColumn(name = "job_advert_id")
    @ManyToOne
    private JobAdvertisement jobAdvertisement;
}
