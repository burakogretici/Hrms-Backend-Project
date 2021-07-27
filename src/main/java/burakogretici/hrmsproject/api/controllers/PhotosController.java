package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.PhotoService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.ErrorDataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/cvs/photos")
public class PhotosController {

    private PhotoService photoService;


    @Autowired
    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<Result> add(@RequestParam int cvId, @RequestBody MultipartFile file) throws IOException {
        var result = photoService.add(cvId, file);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Photo>>> getAll() {
        var result = photoService.getAll();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbycvid")
    public ResponseEntity<DataResult<Photo>> getByCv_Id(int cvId) {
        var result = photoService.getByCv_Id(cvId);
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
