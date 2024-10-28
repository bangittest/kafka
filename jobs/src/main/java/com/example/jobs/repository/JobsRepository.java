package com.example.jobs.repository;

import com.example.jobs.dto.JobResDto;
import com.example.jobs.entity.Jobs;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,Long> {
  List<Jobs> getAllById(Long id);
  @Query("select new com.example.jobs.dto.JobResDto(j.title,j.description) from Jobs j where j.id=:id")
  JobResDto gJobsDtoById(Long id);
  @Query(value = "SELECT j.title,j.description from Jobs j where j.id=:id",nativeQuery = true)
  List<Object[]> getAllDataById(@Param("id") Long id);

}
