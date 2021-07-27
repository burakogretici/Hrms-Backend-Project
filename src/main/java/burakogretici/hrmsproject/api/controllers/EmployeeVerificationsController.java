package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.EmployeeVerificationService;
import burakogretici.hrmsproject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employeeverifications")
public class EmployeeVerificationsController {
    private final EmployeeVerificationService employeeVerificationService;

    @Autowired
    public EmployeeVerificationsController(EmployeeVerificationService employeeVerificationService) {
        this.employeeVerificationService = employeeVerificationService;
    }

    @GetMapping("/verify")
    public ResponseEntity<Result> verify(@RequestParam int id) {
        var result = employeeVerificationService.verify(id);
        if (!result.isSuccess()){
            return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(result);
    }
}
