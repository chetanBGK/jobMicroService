package com.job.jobsms.Job;

//import org.springframework.web.bind.annotation.*;

import com.job.jobsms.Job.DTO.JobDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class JobCOntroller {
    
    JobService  jobService;

    public JobCOntroller(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("createjob")
    public Job createJob(@RequestBody Job job) {
              
        return jobService.createJob(job);
    }

    @GetMapping("getalljobs")
    public List<JobDTO> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("getjobbyid/{id}")
    public Job getJobById(@PathVariable int id) {
        return jobService.getJobById(id);
    }

    @PutMapping("updatejob/{id}")
    public Job updateJob(@PathVariable int id, @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }
    
    @PostMapping("createalljobs")
    public List<Job> createAllJobs(@RequestBody List<Job> jobs) {
        return jobService.createAllJobs(jobs);
    }

    @DeleteMapping("deletealljob")
    public void deleteAllJobs()
    {
        jobService.deleteAllCompany();
    }
    
//    @GetMapping("getbycompany/{id}")
//    public List<Job> getMethodName(@PathVariable int id) {
//        return jobService.findByCompanyId(id);
//    }
    
}
