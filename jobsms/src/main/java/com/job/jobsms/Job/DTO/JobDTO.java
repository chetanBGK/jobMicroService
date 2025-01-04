package com.job.jobsms.Job.DTO;

import com.job.jobsms.Job.Job;
import com.job.jobsms.Job.external.Company;
import com.job.jobsms.Job.external.Review;

import java.util.ArrayList;
import java.util.List;

public class JobDTO {
    private Job job;
    private Company company;
    private List<Review> review;

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

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
