package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.AuthService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.ErrorDataResult;
import burakogretici.hrmsproject.entities.dtos.EmployerForRegisterDto;
import burakogretici.hrmsproject.entities.dtos.JobSeekerForRegisterDto;
import burakogretici.hrmsproject.entities.dtos.LoginForDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @PostMapping("/registeremployer")
    public ResponseEntity<?> employerRegister(@RequestBody EmployerForRegisterDto employerForRegisterDto) {

        var userExists = authService.userExists(employerForRegisterDto.getEmail());
        if (!userExists.isSuccess()) {
            return new ResponseEntity<>(userExists.getMessage(), HttpStatus.BAD_REQUEST);
        }
        var register = this.authService.employerRegister(employerForRegisterDto);
        if (register.isSuccess()) {
            return ResponseEntity.ok(employerForRegisterDto);
        }
        return new ResponseEntity<>(register.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/registerjobseeker")
    public ResponseEntity<?> jobSeekerRegister(@RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto) {
        var userExists = authService.userExists(jobSeekerForRegisterDto.getEmail());
        if (!userExists.isSuccess()) {
            return new ResponseEntity<>(userExists.getMessage(), HttpStatus.BAD_REQUEST);
        }
        var register = this.authService.jobSeekerRegister(jobSeekerForRegisterDto);
        if (register.isSuccess()) {
            return ResponseEntity.ok(register);
        }
        return new ResponseEntity<>(register.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/userlogin")
    public ResponseEntity<?> login(@RequestBody LoginForDto loginForDto) {
        var userToLogin = authService.login(loginForDto);
        if (!userToLogin.isSuccess()) {
            return new ResponseEntity<>(userToLogin, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userToLogin);
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