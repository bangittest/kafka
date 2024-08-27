package com.example.jobs.repository;

import com.example.jobs.entity.Jobs;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,Long> {
  List<Jobs> getAllById(Long id);

}
