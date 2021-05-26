package burakogretici.hrmsproject.api.controllers;

import java.util.List;

import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burakogretici.hrmsproject.business.abstracts.PositionService;
import burakogretici.hrmsproject.entities.concretes.Position;

import javax.validation.Valid;

@RestController
@RequestMapping("api/positions")
public class PositionsController {

    private PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService) {
        super();
        this.positionService = positionService;
    }

    @GetMapping("/getall")
    public DataResult<List<Position>> getAll(){
        return this.positionService.getAll();
    }
    @PostMapping("/add")
    public Result add(@Valid @RequestBody Position position)  {
        return this.positionService.add(position);
    }
}


