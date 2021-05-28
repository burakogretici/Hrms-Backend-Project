package burakogretici.hrmsproject.entities.dtos;

import burakogretici.hrmsproject.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegisterDto implements Dto {

    @NotEmpty(message = "Email cannot be empty")
    @Email
    private String email;

    @NotEmpty(message = "password cannot be empty")
    private String password;

    @NotEmpty(message = "Confirm password cannot be empty")
    private String confirmPassword;

    @NotEmpty(message = "Company name cannot be empty")
    @Size(max = 100)
    private String companyName;

    @NotEmpty(message = "Web site cannot be empty")
    @Size(max = 100)
    private String website;

    @NotEmpty(message = "Phone cannot be empty")
    @Size(max = 15)
    private String phone;
}

