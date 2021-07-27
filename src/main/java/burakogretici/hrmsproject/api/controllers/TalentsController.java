package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.TalentService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.ErrorDataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Talent;
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
@RequestMapping("/api/cvs/talents")
public class TalentsController {
    private TalentService talentService;

    @Autowired
    public TalentsController(TalentService talentService) {
        this.talentService = talentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid Talent talent) {
        var result = talentService.add(talent);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Talent>>> getAll() {
        var result = talentService.getAll();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/get/bycvid")
    public ResponseEntity<DataResult<List<Talent>>> getAllByCv_Id(int cvId) {
        var result = talentService.getAllByCv_Id(cvId);
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
