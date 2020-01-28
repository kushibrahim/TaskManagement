package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<MetricEntity, Integer> {
}
