package com.example.jobs.controller;

import com.example.jobs.entity.Jobs;
import com.example.jobs.service.JobsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JobsController {
  private final JobsService jobsService;

  @GetMapping("/jobs")
  @ResponseStatus(HttpStatus.OK)
  public List<Jobs> getJobs() {
    return jobsService.findAll();
  }

  @PostMapping("/jobs")
  @ResponseStatus(HttpStatus.CREATED)
  public Jobs createJob(@RequestBody Jobs jobs) {
    return jobsService.createJob(jobs);
  }

  @GetMapping("/jobs/{jobId}")
  @ResponseStatus(HttpStatus.OK)
  public List<Jobs> getAllListById(@PathVariable(name = "jobId") Long jobId) {
    return jobsService.getAllById(jobId);
  }
}
