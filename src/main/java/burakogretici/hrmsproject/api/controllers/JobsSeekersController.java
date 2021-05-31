package burakogretici.hrmsproject.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import burakogretici.hrmsproject.business.abstracts.JobSeekerService;
import burakogretici.hrmsproject.entities.concretes.JobSeeker;

import javax.validation.Valid;

@RestController
@RequestMapping("api/jobSeekers")
public class JobsSeekersController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobsSeekersController(JobSeekerService jobSeekerService) {
        super();
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<JobSeeker>>> getAll() {
        var result = jobSeekerService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
        var result = jobSeekerService.add(jobSeeker);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, Messages.verificationErrors);
        return errors;
    }
}

