package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.UserService;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<User>>> getAll() {
        var result = userService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
     return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        return ResponseEntity.ok(this.userService.add(user));
    }
}
