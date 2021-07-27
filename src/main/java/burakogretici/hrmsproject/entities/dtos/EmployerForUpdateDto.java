package burakogretici.hrmsproject.entities.dtos;

import burakogretici.hrmsproject.core.entities.abstracts.Dto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class EmployerForUpdateDto implements Dto {
    @NotNull
    private int id;

    @NotBlank
    @Size(max = 100)
    private String companyName;

    @NotBlank
    @Size(max = 100)
    private String website;

    @NotBlank
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(max = 15)
    private String phone;

    @NotBlank
    @Size(max = 100)
    private String password;
}
