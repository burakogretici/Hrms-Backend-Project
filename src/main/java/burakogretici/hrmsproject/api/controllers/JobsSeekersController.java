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

import burakogretici.hrmsproject.business.abstracts.JobSeekerService;
import burakogretici.hrmsproject.entities.concretes.JobSeeker;

import javax.validation.Valid;

@RestController
@RequestMapping("api/jobSeekers")
public class JobsSeekersController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobsSeekersController(JobSeekerService jobSeekerService) {
        super();
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll() {

        return this.jobSeekerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.add(jobSeeker);
    }
}

