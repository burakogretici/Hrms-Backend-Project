package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.JobAdvertisementService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.ErrorDataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.JobAdvertisement;
import burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/jobAdvertisements")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> getAll() {
        var result = jobAdvertisementService.getAll();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody JobAdvertisement jobAdvertisement) {
        var result = jobAdvertisementService.add(jobAdvertisement);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/getall/byisactiveandemployercompanyname")
    public ResponseEntity<DataResult<List<JobAdvertisementDto>>> getAllByIsActiveAndEmployer_CompanyName(@RequestParam boolean isActive, @RequestParam String companyName) {
        var result = jobAdvertisementService.getAllByIsActiveAndEmployer_CompanyName(isActive, companyName);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getall/byisactive")
    public ResponseEntity<DataResult<List<JobAdvertisementDto>>> getAllByIsActive(@RequestParam boolean isActive) {
        var result = jobAdvertisementService.getAllByIsActive(isActive);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getall/byisactive/orderby/createddate")
    public ResponseEntity<DataResult<List<JobAdvertisementDto>>> getAllByIsActiveOrderByCreatedDate(@RequestParam boolean isActive, String sort) {
        var result = jobAdvertisementService.getAllByIsActiveOrderByCreatedDate(isActive, sort);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/update/closebypostingid")
    public ResponseEntity<?> orderByPostingId(@RequestParam int id) {
        var result = jobAdvertisementService.closeByPostingId(id);
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