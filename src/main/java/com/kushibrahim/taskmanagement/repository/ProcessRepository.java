package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.model.enumerator.MetricType;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessEntity,Integer> {

    @Query("select p from ProcessEntity p JOIN p.tasks t JOIN t.metrics m where t.taskActualEndDate > t.taskOriginalEndDate and m.metricType = :metricType and p.processStatus <> :processStatus")
    List<ProcessEntity> processDone(MetricType metricType, Status processStatus);
}
