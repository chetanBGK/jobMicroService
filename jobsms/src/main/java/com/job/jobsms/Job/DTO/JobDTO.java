package com.job.jobsms.Job.DTO;

import com.job.jobsms.Job.Job;
import com.job.jobsms.Job.external.Company;

import java.util.ArrayList;
import java.util.List;

public class JobDTO {
    private Job job;
    private Company company;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
