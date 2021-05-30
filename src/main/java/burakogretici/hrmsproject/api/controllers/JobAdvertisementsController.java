package burakogretici.hrmsproject.api.controllers;

import burakogretici.hrmsproject.business.abstracts.JobAdvertisementService;
import burakogretici.hrmsproject.core.utilities.results.DataResult;
import burakogretici.hrmsproject.core.utilities.results.Result;
import burakogretici.hrmsproject.entities.concretes.JobAdvertisement;
import burakogretici.hrmsproject.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getall/byisactiveandemployercompanyname")
    public DataResult<List<JobAdvertisementDto>> getAllByIsActiveAndEmployer_CompanyName(@RequestParam boolean isActive, @RequestParam String companyName) {
        return this.jobAdvertisementService.getAllByIsActiveAndEmployer_CompanyName(isActive, companyName);

    }

    @GetMapping("/getall/byisactive")
    public DataResult<List<JobAdvertisementDto>> getAllByIsActive(@RequestParam boolean isActive) {
        return this.jobAdvertisementService.getAllByIsActive(isActive);

    }

    @GetMapping("/getall/byisactive/orderby/createddate")
    public DataResult<List<JobAdvertisementDto>> getAllByIsActiveOrderByCreatedDate(@RequestParam boolean isActive,String sort) {
        return this.jobAdvertisementService.getAllByIsActiveOrderByCreatedDate(isActive,sort);

    }

    @GetMapping("/update/closebypostingid")
    public Result orderByPostingId(@RequestParam int id) {
        return this.jobAdvertisementService.closeByPostingId(id);

    }
}