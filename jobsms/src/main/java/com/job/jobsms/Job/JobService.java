package com.job.jobsms.Job;

import com.job.jobsms.Job.DTO.JobDTO;

import java.util.List;

public interface JobService {
    Job createJob(Job job);
    Job getJobById(int id);
    Job updateJob(int id, Job job);
    void deleteJob(int id);
    List<JobDTO> getAllJobs();
    List<Job> createAllJobs(List<Job> jobs);
    void deleteAllCompany();
//    List<Job> findByCompanyId(int companyId);
}  

