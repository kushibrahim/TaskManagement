package com.kushibrahim.taskmanagement.repository.impl;

import com.kushibrahim.taskmanagement.model.entity.DeveloperEntity;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.entity.TeamLeadEntity;
import com.kushibrahim.taskmanagement.model.request.CreateTaskRequest;
import com.kushibrahim.taskmanagement.repository.TaskRepository;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TaskRepositoryImpl extends SimpleJpaRepository<TaskEntity, Integer> implements TaskRepository {

    private static final String TASK_NAME = "ExampleTask";
    private static final Integer DEVELOPER_ID = 1;

    private final EntityManager entityManager;

    public TaskRepositoryImpl(EntityManager entityManager) {
        super(TaskEntity.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public TaskEntity assigneeTask(Integer taskId, Integer assigneeId) {
        Session session = entityManager.unwrap(Session.class);
        TaskEntity taskEntity = session.get(TaskEntity.class,taskId);
        //Features will be added.

        return taskEntity;
    }

    @Override
    public TaskEntity updateTask(TaskEntity task) {
        return super.save(task);
    }

    @Override
    public CreateTaskRequest createRequest(CreateTaskRequest request) {
        Session session = entityManager.unwrap(Session.class);
        CreateTaskRequest taskRequest = new CreateTaskRequest();

        DeveloperEntity developerEntity = new DeveloperEntity();
        ProcessEntity processEntity = new ProcessEntity();
        TeamLeadEntity teamLeadEntity = new TeamLeadEntity();

        taskRequest.setTaskName(TASK_NAME);
        taskRequest.setDeveloperEntityID(developerEntity);
        taskRequest.setProcessID(processEntity);
        taskRequest.setTeamLeadEntityID(teamLeadEntity);
        session.save(taskRequest);

        return taskRequest;
    }

    @Override
    public List<TaskEntity> getAllOverDueTask() {
         List<TaskEntity> entities = entityManager.createQuery("select t from TaskEntity t where t.taskActualEndDate > t.taskOriginalEndDate ").getResultList();
        return entities;
    }

}
