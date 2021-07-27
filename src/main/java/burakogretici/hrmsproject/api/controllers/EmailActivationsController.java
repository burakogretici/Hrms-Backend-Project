package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.EmailActivationService;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.dtos.EmailActivationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/emailactivations")
public class EmailActivationsController {
    private EmailActivationService emailActivationService;

    @Autowired
    public EmailActivationsController(EmailActivationService emailActivationService) {
        this.emailActivationService = emailActivationService;
    }

    @GetMapping("/verify")
    public ResponseEntity<Result> verify(@Valid EmailActivationDto emailActivationDto) {
         var result = emailActivationService.verify(emailActivationDto);

        if (!result.isSuccess())
            return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(result);
    }
}
