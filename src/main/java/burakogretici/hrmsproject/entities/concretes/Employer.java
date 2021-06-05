package burakogretici.hrmsproject.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import burakogretici.hrmsproject.core.entities.concretes.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@Table(name="employers")
public class Employer extends User {


    @NotEmpty(message = "Company name cannot be empty")
    @Column(name="company_name")
    private String companyName;

    @NotEmpty(message = "Web site cannot be empty")
    @Column(name="web_site")
    private String webSite;

    @NotEmpty(message = "Phone cannot be empty")
    @Column(name="phone")
    private String phone;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;


}
