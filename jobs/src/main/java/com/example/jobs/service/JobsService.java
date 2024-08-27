package com.example.jobs.service;

import com.example.jobs.entity.Jobs;
import java.util.List;

public interface JobsService {
  List<Jobs> findAll();
  Jobs createJob(Jobs jobs);
  List<Jobs> getAllById(Long id);
}
