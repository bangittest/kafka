package com.example.company.repository;

import com.example.company.entity.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
  List<Company> getAllById(Long id);

}
