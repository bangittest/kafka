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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
  private final CompanyRepository companyRepository;
  private final JobClient jobClient;
  private final ModelMapper modelMapper;
  private final RestTemplate restTemplate;
  @Value("${job-service.url}")
  private String host;
  private final StringBuilder stringBuilder = new StringBuilder();

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
    if (companyList.isEmpty()) {
      throw new RuntimeException("No company found with id " + id);
    }

//    List<CompanyJob> companyJobs = new ArrayList<>();
//
//    for (Company company : companyList){
//      CompanyJob companyJob = new CompanyJob();
//      companyJob.setContact(company.getContact());
//      companyJob.setId(company.getId());
//      companyJob.setAddress(company.getAddress());
//      companyJob.setDescription(company.getDescription());
//      companyJob.setName(company.getName());
//
//    List<JobResponse>jobResponseList = jobClient.getListJobResponse(company.getId());
//    companyJob.setJobResponse(jobResponseList);
//
//      companyJobs.add(companyJob);
//    }

    return companyList.stream().map(company -> {
      CompanyJob companyJob = new CompanyJob();
      modelMapper.map(company, companyJob);
      List<JobResponse>jobResponseList = jobClient.getListJobResponse(company.getId());
      companyJob.setJobResponse(jobResponseList);
//      try {
//        ResponseEntity<List<JobResponse>> response = restTemplate.exchange(
//            "http://localhost:8086/jobs/1",
//            HttpMethod.GET,
//            null,
//            new ParameterizedTypeReference<>() {}
//        );
//
//        List<JobResponse> jobResponseList = response.getBody() != null ? response.getBody() : new ArrayList<>();
//        companyJob.setJobResponse(jobResponseList);
//      } catch (RestClientException e) {
//        companyJob.setJobResponse(new ArrayList<>());
//        System.out.println("Error fetching JobResponse list: " + e.getMessage());
//      }
      return companyJob;
    }) .toList();
  }
}
