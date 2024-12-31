package com.jobpackage.jobpackage.Company;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/company")
public class CompanyController {
    
    CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("createcompany")
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @GetMapping("getallcompany")
    public List<Company> getAllCompany() {
        return companyService.getAllCompanies();
    }

    @GetMapping("getcompanybyid/{id}")
    public Company getCompanyById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    @PutMapping("updatecompany/{id}")
    public Company updateCompany(@PathVariable int id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    @DeleteMapping("deletecompany/{id}")
    public void deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
    }

    @PostMapping("crearteallcompany")
    public List<Company> createAllCompany(@RequestBody List<Company> company) {
        return companyService.createAllCompany(company);
    }
    
    
    
}
