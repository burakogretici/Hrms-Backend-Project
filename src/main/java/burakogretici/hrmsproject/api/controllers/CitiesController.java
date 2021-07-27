package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.CityService;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        super();
        this.cityService = cityService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<City>>> getAll() {
        var result = cityService.getAll();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody City city) {

        var result = cityService.add(city);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

}
