package com.example.company.service;

import com.example.company.external.CompanyJob;
import com.example.company.entity.Company;
import java.util.List;

public interface CompanyService {
  List<Company> getAllCompanies();
  Company createCompany(Company company);
  List<CompanyJob> getAllById(Long id);

}
