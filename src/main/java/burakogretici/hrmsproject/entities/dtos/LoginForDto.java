package burakogretici.hrmsproject.entities.dtos;

import burakogretici.hrmsproject.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForDto implements Dto {

    @NotEmpty(message = "Email cannot be empty")
    @Email
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
