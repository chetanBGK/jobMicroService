package com.jobpackage.jobpackage.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company company);
    Company getCompanyById(int id);
    Company updateCompany(int id, Company company);
    void deleteCompany(int id);
    List<Company> getAllCompanies();
    List<Company> createAllCompany(List<Company> company);

}
