package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.ExperienceService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.ErrorDataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/cvs/experiences")
public class ExperiencesController {
    private ExperienceService experienceService;

    @Autowired
    public ExperiencesController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid Experience experience) {
        var result = experienceService.add(experience);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Experience>>> getAll() {
        var result = experienceService.getAll();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getall/bycvid")
    public ResponseEntity<DataResult<List<Experience>>> getAllByCv_Id(int cvId) {
        var result = experienceService.getAllByCv_Id(cvId);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getall/bycvidorderbyenddate")
    public ResponseEntity<DataResult<List<Experience>>> getAllByCv_IdOrderByEndDate(@RequestParam int jobSeekerCVId, @RequestParam String direction) {
        var result = experienceService.getAllByCv_IOrderByEndDate(jobSeekerCVId, direction);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, Messages.verificationErrors);
        return errors;
    }
}
