package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.UserService;
import burakogretici.hrmsproject.business.abstracts.WayOfWorkingService;
import burakogretici.hrmsproject.core.entities.concretes.User;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.entities.concretes.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/wayOfWorkings")
public class WayOfWorkingsController {

    private WayOfWorkingService wayOfWorkingService;

    @Autowired
    public WayOfWorkingsController(WayOfWorkingService wayOfWorkingService) {
        super();
        this.wayOfWorkingService = wayOfWorkingService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<WayOfWorking>>> getAll() {
        var result = wayOfWorkingService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody WayOfWorking wayOfWorking) {
        return ResponseEntity.ok(this.wayOfWorkingService.add(wayOfWorking));
    }
}

