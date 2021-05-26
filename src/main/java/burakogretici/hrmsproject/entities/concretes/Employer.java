package burakogretici.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.servlet.annotation.WebFilter;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employers")
public class Employer extends User  {

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
