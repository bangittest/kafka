package com.example.company.external;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyJob {
  Long id;
  String name;
  String description;
  String address;
  String contact;
  List<JobResponse> jobResponse;
}
