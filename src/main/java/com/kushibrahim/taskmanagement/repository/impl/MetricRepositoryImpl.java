package com.kushibrahim.taskmanagement.repository.impl;

import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import com.kushibrahim.taskmanagement.repository.MetricRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class MetricRepositoryImpl extends SimpleJpaRepository<MetricEntity,Integer> implements MetricRepository {

    private EntityManager entityManager;

    public MetricRepositoryImpl(EntityManager entityManager) {
        super(MetricEntity.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<MetricEntity> getAllDoneSuccessMetrics() {
        List<MetricEntity> entities = this.findAll();
        return entities.stream()
                .filter(x -> x.getMetricType().name().equals("DONE"))
                .collect(Collectors.toList());
    }
}
