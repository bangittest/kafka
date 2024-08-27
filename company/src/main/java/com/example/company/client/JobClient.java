package com.example.company.client;

import com.example.company.external.JobResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "JOBS-SERVICE",url="${job-service.url}")
public interface JobClient {
  @GetMapping("/jobs/{jobId}")
  List<JobResponse> getListJobResponse(@PathVariable("jobId") Long jobId);
}
