package com.example.company.service.Impl;

import com.example.company.client.JobClient;
import com.example.company.external.CompanyJob;
import com.example.company.entity.Company;
import com.example.company.external.JobResponse;
import com.example.company.repository.CompanyRepository;
import com.example.company.service.CompanyService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
  private final CompanyRepository companyRepository;
  private final JobClient jobClient;

  @Override
  public List<Company> getAllCompanies() {
    return companyRepository.findAll();
  }

  @Override
  public Company createCompany(Company company) {
    Company companyNew = new Company();
    companyNew.setName(company.getName());
    companyNew.setAddress(company.getAddress());
    companyNew.setContact(company.getContact());
    companyNew.setDescription(company.getDescription());
    companyRepository.save(companyNew);
    return companyNew;
  }

  @Override
  public List<CompanyJob> getAllById(Long id) {
    List<Company> companyList = companyRepository.getAllById(id);
    List<CompanyJob> companyJobs = new ArrayList<>();

    for (Company company : companyList){
      CompanyJob companyJob = new CompanyJob();
      companyJob.setContact(company.getContact());
      companyJob.setId(company.getId());
      companyJob.setAddress(company.getAddress());
      companyJob.setName(company.getName());

      List<JobResponse>jobResponseList = jobClient.getListJobResponse(company.getId());
      companyJob.setJobResponse(jobResponseList);
      companyJobs.add(companyJob);
    }

    return companyJobs;
  }
}
