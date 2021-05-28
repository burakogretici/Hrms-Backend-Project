package burakogretici.hrmsproject.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import burakogretici.hrmsproject.core.entities.concretes.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

}
