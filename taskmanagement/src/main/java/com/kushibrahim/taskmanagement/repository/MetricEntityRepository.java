package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricEntityRepository extends JpaRepository<MetricEntity, Integer> {
}
