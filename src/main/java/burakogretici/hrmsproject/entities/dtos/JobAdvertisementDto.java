package burakogretici.hrmsproject.entities.dtos;

import burakogretici.hrmsproject.core.entities.abstracts.Dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class JobAdvertisementDto implements Dto {

    @NotEmpty(message = "Company name cannot be empty")
    private String companyName;

    @NotEmpty(message = " Position name cannot be empty")
    private String positionName;

    @NotEmpty(message = " Quantity cannot be empty")
    private int quantity;

    @CreationTimestamp
    private Date releaseDate;

    @NotEmpty(message = "Deadline cannot be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date deadline;

    @Builder
    public JobAdvertisementDto(String companyName,
                               String positionName, @Positive int quantity,
                               @Past Date releaseDate,@Future Date deadline) {
        this.companyName = companyName;
        this.positionName = positionName;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
        this.deadline = deadline;
    }
}
