package com.example.company.controller;

import com.example.company.entity.Company;
import com.example.company.external.CompanyJob;
import com.example.company.service.CompanyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CompanyController {
  private final CompanyService companyService;
//  @GetMapping("/company")
//  @ResponseStatus(HttpStatus.OK)
//  public List<Company>getAll(){
//    return companyService.getAllCompanies();
//  }

  @PostMapping("/company")
  @ResponseStatus(HttpStatus.CREATED)
  public Company createCompany(@RequestBody  Company company){
    return companyService.createCompany(company);
  }

  @GetMapping("/company/{companyId}")
  @ResponseStatus(HttpStatus.OK)
  public List<CompanyJob> getAllById(@PathVariable(name = "companyId") Long companyId){
    return companyService.getAllById(companyId);
  }
}
