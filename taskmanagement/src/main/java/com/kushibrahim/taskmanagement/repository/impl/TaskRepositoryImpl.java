package com.kushibrahim.taskmanagement.repository.impl;

import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.repository.TaskRepository;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
public class TaskRepositoryImpl extends SimpleJpaRepository<TaskEntity, Integer> implements TaskRepository {

    private final EntityManager entityManager;

    public TaskRepositoryImpl(EntityManager entityManager) {
        super(TaskEntity.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public TaskEntity assigneeTask(Integer taskId, Integer assigneeId) {
        Session session = entityManager.unwrap(Session.class);
        return null;
    }

    @Override
    public TaskEntity updateTask(Integer taskId) {
        Session session = entityManager.unwrap(Session.class);
        TaskEntity taskEntity = session.get(TaskEntity.class,taskId);
        session.saveOrUpdate(taskEntity);
        return taskEntity;
    }
}
