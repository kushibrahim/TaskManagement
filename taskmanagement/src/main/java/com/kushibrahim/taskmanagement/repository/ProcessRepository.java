package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessEntity,Integer> {
}
