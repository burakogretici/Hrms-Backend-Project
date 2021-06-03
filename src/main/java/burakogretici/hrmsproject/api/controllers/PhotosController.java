package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.PhotoService;
import burakogretici.hrmsproject.business.conctants.Messages;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.ErrorDataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Cv;
import burakogretici.hrmsproject.entities.concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cvs/photos")
public class PhotosController {

    private PhotoService photoService;


    @Autowired
    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/addandsave")
    public ResponseEntity<Result> addAndSave(@RequestParam int cvId, @RequestBody MultipartFile file) {
        Result result = photoService.addAndSave(Photo.builder().cv(Cv.builder().id(cvId).build()).build(), file);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Photo>>> getAll() {
        DataResult<List<Photo>> result = photoService.getAll();

        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Photo photo) {
        Result result = photoService.add(photo);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall/bycvid")
    public ResponseEntity<DataResult<List<Photo>>> getAllByJobSeekerCV_Id(int cvId) {
        final DataResult<List<Photo>> result = photoService.getAllByCv_Id(cvId);

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
