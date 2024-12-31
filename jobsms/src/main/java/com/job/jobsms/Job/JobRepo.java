package com.job.jobsms.Job;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepo extends JpaRepository<Job,Integer>{
//    List<Job> findByCompanyId(int companyId);

}
