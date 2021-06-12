package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.WayOfWorkingService;
import burakogretici.hrmsproject.business.abstracts.WorkingTimeService;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.entities.concretes.WayOfWorking;
import burakogretici.hrmsproject.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/workingTimes")
public class WorkingTimesController {
    private WorkingTimeService workingTimeService;

    @Autowired
    public WorkingTimesController(WorkingTimeService workingTimeService) {
        super();
        this.workingTimeService = workingTimeService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<WorkingTime>>> getAll() {
        var result = workingTimeService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody WorkingTime workingTime) {
        return ResponseEntity.ok(this.workingTimeService.add(workingTime));
    }
}
