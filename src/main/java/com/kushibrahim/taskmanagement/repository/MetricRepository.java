package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetricRepository extends JpaRepository<MetricEntity, Integer> {
    List<MetricEntity> getAllDoneSuccessMetrics();
}
