package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.JobAdvertisementService;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.JobAdvertisement;
import burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobAdvertisements")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();

    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getall/byisActiveAndEmployerCompanyname")
    public DataResult<List<JobAdvertisementDto>> getAllByIsActiveAndEmployer_CompanyName(@RequestParam boolean isActive, @RequestParam String companyName) {
        return this.jobAdvertisementService.getAllByIsActiveAndEmployer_CompanyName(isActive, companyName);

    }

    @GetMapping("/getall/byisActive")
    public DataResult<List<JobAdvertisementDto>> getAllByIsActive(@RequestParam boolean isActive) {
        return this.jobAdvertisementService.getAllByIsActive(isActive);

    }
}