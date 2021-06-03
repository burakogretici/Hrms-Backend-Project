package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.CvService;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.Cv;
import burakogretici.hrmsproject.entities.concretes.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {

    private CvService cvService;

    @Autowired
    public CvsController( CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid Cv cv) {
        Result result = cvService.add(cv);

        return ResponseEntity.ok(result);
    }
    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Cv>>> getAll() {
        DataResult<List<Cv>> result = cvService.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/byjobseekercvid")
    public ResponseEntity<DataResult<List<Cv>>> getAllByCv_Id(int jobSeekerId) {
        DataResult<List<Cv>> result = cvService.getByJobSeeker_Id(jobSeekerId);

        return ResponseEntity.ok(result);
    }
}
