package burakogretici.hrmsproject.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.ErrorDataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import burakogretici.hrmsproject.business.abstracts.DepartmentService;
import burakogretici.hrmsproject.entities.concretes.Department;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("api/departments")
public class DepartmentsController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentsController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Department>>> getAll() {
        var result = departmentService.getAll();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Department department) {

        var result = departmentService.add(department);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors, Messages.verificationErrors);
        return errors;
    }
}
