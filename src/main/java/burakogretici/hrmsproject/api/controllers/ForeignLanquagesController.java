package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.ForeignLanguageService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.ErrorDataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.ForeignLanguage;
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
@RequestMapping("/api/cvs/foreignLanguages")
public class ForeignLanquagesController {
    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanquagesController(ForeignLanguageService foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid ForeignLanguage foreignLanguage) {
        Result result = foreignLanguageService.add(foreignLanguage);

        return ResponseEntity.ok(result);
    }
    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<ForeignLanguage>>> getAll() {
        DataResult<List<ForeignLanguage>> result = foreignLanguageService.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/bycvid")
    public ResponseEntity<DataResult<List<ForeignLanguage>>> getAllByCV_Id(int cvId) {
        DataResult<List<ForeignLanguage>> result = foreignLanguageService.getAllByCv_Id(cvId);

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
