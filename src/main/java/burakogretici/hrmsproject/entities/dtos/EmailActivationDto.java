package burakogretici.hrmsproject.entities.dtos;

import burakogretici.hrmsproject.core.entities.abstracts.Dto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class EmailActivationDto implements Dto {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String activationCode;


}
