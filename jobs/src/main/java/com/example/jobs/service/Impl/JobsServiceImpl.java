package com.example.jobs.service.Impl;

import com.example.jobs.entity.Jobs;
import com.example.jobs.repository.JobsRepository;
import com.example.jobs.service.JobsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobsServiceImpl implements JobsService {

  private final JobsRepository jobsRepository;

  @Override
  public List<Jobs> findAll() {
    return jobsRepository.findAll();
  }

  @Override
  public Jobs createJob(Jobs jobs) {
    Jobs jobsNew = new Jobs();
    jobsNew.setTitle(jobs.getTitle());
    jobsNew.setDescription(jobs.getDescription());
    jobsRepository.save(jobsNew);
    return jobsNew;
  }

  @Override
  public List<Jobs> getAllById(Long id) {
    return jobsRepository.getAllById(id);
  }

}
