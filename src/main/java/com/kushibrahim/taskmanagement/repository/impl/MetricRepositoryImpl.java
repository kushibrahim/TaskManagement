package com.kushibrahim.taskmanagement.repository.impl;

import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.model.enumerator.MetricType;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import com.kushibrahim.taskmanagement.repository.MetricRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MetricRepositoryImpl extends SimpleJpaRepository<MetricEntity,Integer> implements MetricRepository {

    private EntityManager entityManager;

    public MetricRepositoryImpl(EntityManager entityManager) {
        super(MetricEntity.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<MetricEntity> getAllDoneSuccessMetrics() {
        Query query = entityManager.createQuery("select m from MetricEntity m where  m.metricType = :type ");
        query.setParameter("type", MetricType.DONE);
        List<MetricEntity> entities = query.getResultList();
        return entities;
    }

}
