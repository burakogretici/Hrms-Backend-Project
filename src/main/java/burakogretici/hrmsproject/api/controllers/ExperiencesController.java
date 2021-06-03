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
@RequestMapping("/api/cvs/experiences")
public class ExperiencesController {
    private ExperienceService experienceService;

    @Autowired
    public ExperiencesController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid Experience experience) {
        Result result = experienceService.add(experience);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Experience>>> getAll() {

        DataResult<List<Experience>> result = experienceService.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall/bycvid")
    public ResponseEntity<DataResult<List<Experience>>> getAllByCv_Id(int jobSeekerCVId) {
        DataResult<List<Experience>> result = experienceService.getAllByCv_Id(jobSeekerCVId);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall/bycvidorderbyenddate")
    public ResponseEntity<DataResult<List<Experience>>> getAllByCv_IdOrderByEndDate(@RequestParam int jobSeekerCVId, @RequestParam String direction) {
        DataResult<List<Experience>> result = experienceService.getAllByCv_IOrderByEndDate(jobSeekerCVId, direction);

        return ResponseEntity.ok(result);
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
