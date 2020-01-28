package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessEntityRepository extends JpaRepository<ProcessEntity,Integer> {
}
