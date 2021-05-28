package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.UserService;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.core.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll() {

        return this.userService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody User user) {
        return this.userService.add(user);
    }
}
