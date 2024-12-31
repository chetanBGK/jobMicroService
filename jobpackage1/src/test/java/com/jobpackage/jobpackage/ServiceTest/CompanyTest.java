package com.jobpackage.jobpackage.ServiceTest;

import com.jobpackage.jobpackage.Company.CompanyRepo;
import com.jobpackage.jobpackage.Company.ServiceImpl.CompanyServiceImpl;
import com.jobpackage.jobpackage.Job.Job;
import com.jobpackage.jobpackage.Review.Review;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jobpackage.jobpackage.Company.Company;
import com.jobpackage.jobpackage.Company.CompanyService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CompanyTest {
   
    @InjectMocks
    CompanyServiceImpl companyService;

    @Mock
    CompanyRepo companyRepo;

    List<Review> reviews= new ArrayList<>() ;

    List<Job> jobs=new ArrayList<>();

    @Test
    public void testCreateCompany() {
        Company company = new Company();

        company.setName("test");
        company.setDescription("test");
        company.setJobs(jobs);
        company.setReviews(reviews);

        Mockito.when(companyRepo.save(company)).thenReturn(company);
        Company createCompany= companyService.createCompany(company);

        Assertions.assertEquals(company.getName(),"test");
    }
}
