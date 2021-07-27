package burakogretici.hrmsproject.entities.dtos;

import burakogretici.hrmsproject.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertFilter implements Dto {

    private List<Integer> cityId;
    private List<Integer> positionId;
    private List<Integer> wayOfWorkingId;
    private List<Integer> workingTimeId;
}
