package burakogretici.hrmsproject.entities.dtos;

import burakogretici.hrmsproject.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobAdvertisementDto implements Dto {

    @NotEmpty(message = "Company name cannot be empty")
    private String companyName;

    @NotEmpty(message = " Position name cannot be empty")
    private String positionName;

    @NotEmpty(message = " Quantity cannot be empty")
    private String quantity;

    @Past
    private LocalDate releaseDate;

    @NotEmpty(message = "Deadline cannot be empty")
    private Date deadline;
}
