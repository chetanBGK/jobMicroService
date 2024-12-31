package com.jobpackage.jobpackage.Company.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobpackage.jobpackage.Company.Company;
import com.jobpackage.jobpackage.Company.CompanyRepo;
import com.jobpackage.jobpackage.Company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
    
    CompanyRepo companyRepo;
    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }
    @Override
    public Company createCompany(Company company) {
        return companyRepo.save(company);
    }
    @Override
    public Company getCompanyById(int id) {
        return companyRepo.findById(id).get();
    }
    @Override
    public Company updateCompany(int id, Company company) {
        return companyRepo.save(company);
    }
    @Override
    public void deleteCompany(int id) {
        companyRepo.deleteById(id);
    }
    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public List<Company> createAllCompany(List<Company> company) {
        return companyRepo.saveAll(company);
    }

}
