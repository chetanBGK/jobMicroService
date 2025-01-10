package com.job.jobsms.Job.ServiceImpl;

import com.job.jobsms.Job.CompanyLdBalance;
import com.job.jobsms.Job.DTO.JobDTO;
import com.job.jobsms.Job.JobRepo;
import com.job.jobsms.Job.Job;
//import com.jobpackage.jobpackage.Job.JobRepo;
import com.job.jobsms.Job.JobService;
import com.job.jobsms.Job.external.Company;
import com.job.jobsms.Job.external.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    RestTemplate restTemplate;

    JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public Job createJob(Job job) {
        return jobRepo.save(job);
    }

    @Override
    public JobDTO getJobById(int id) {

        Job job=jobRepo.findById(id).get();
        JobDTO jobDTO=new JobDTO();

        Company company=restTemplate.getForObject("http://COMPANY-PACKAGE:8081/company/getcompanybyid/"+job.getCompanyId(), Company.class);
        jobDTO.setCompany(company);
        jobDTO.setJob(job);

        ResponseEntity<List<Review>> review=restTemplate.exchange(
                "http://REVIEW-PACKAGE:8082/review?companyId="+job.getCompanyId()
                , HttpMethod.GET
                , null
                ,new ParameterizedTypeReference<List<Review>> (){});

        List<Review> reviews=review.getBody();
        jobDTO.setReview(reviews);
        return jobDTO;
    }

    @Override
    public Job updateJob(int id, Job job) {

        Job job1 = new Job();
        job1 = jobRepo.findById(id).get();
        job1.setTitle(job.getTitle());
        job1.setDescription(job.getDescription());
        job1.setMinsalary(job.getMinsalary());
        job1.setMaxsalary(job.getMaxsalary());
        job1.setLocation(job.getLocation());
        return jobRepo.save(job1);
    }

    @Override
    public void deleteJob(int id) {
        jobRepo.deleteById(id);
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepo.findAll();
        List<JobDTO> jobDTOs=new ArrayList<>();

        for (Job job : jobs) {
            JobDTO jobDTO=new JobDTO();

            jobDTO.setJob(job);
            Company company= restTemplate
                    .getForObject("http://COMPANY-PACKAGE:8081/company/getcompanybyid/"+job.getCompanyId()
                            , Company.class);

            ResponseEntity<List<Review>> reviews=
                    restTemplate.exchange(
                            "http://REVIEW-PACKAGE:8082/review/getallreview?companyId=" + job.getCompanyId()
                            , HttpMethod.GET
                            , null
                            , new ParameterizedTypeReference<List<Review>>() {
                            });


            List<Review> reviewList=reviews.getBody();
            jobDTO.setReview(reviewList);
            jobDTO.setCompany(company);

            jobDTOs.add(jobDTO);

        }

        return jobDTOs;
    }

    public List<Job> createAllJobs(List<Job> jobs) {
        return jobRepo.saveAll(jobs);
    }

    public void deleteAllCompany()
    {
        jobRepo.deleteAll();
    }

//    @Override
//    public List<Job> findByCompanyId(int companyId) {
//        return jobRepo.findByCompanyId(companyId);
//    }

    
}