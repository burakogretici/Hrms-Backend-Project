package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.CvService;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Cv;
import burakogretici.hrmsproject.entities.concretes.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cvs")
public class CvsController {

    private CvService cvService;

    @Autowired
    public CvsController( CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid Cv cv) {
        var result = cvService.add(cv);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Cv>>> getAll() {
        var result = cvService.getAll();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/byjobseekercvid")
    public ResponseEntity<DataResult<List<Cv>>> getAllByCv_Id(int jobSeekerId) {
        var result = cvService.getByJobSeeker_Id(jobSeekerId);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
