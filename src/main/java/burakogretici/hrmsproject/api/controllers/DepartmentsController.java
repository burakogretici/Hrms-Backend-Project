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

import burakogretici.hrmsproject.business.abstracts.DepartmentService;
import burakogretici.hrmsproject.entities.concretes.Department;


@RestController
@RequestMapping("api/departments")
public class DepartmentsController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentsController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<Department>> getAll() {

        return  this.departmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Department department) {
       return this.departmentService.add(department);
    }
}