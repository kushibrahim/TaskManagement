package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import com.kushibrahim.taskmanagement.repository.impl.TaskRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskRepositoryIntegrationTest {

    private static final Integer TASK_ID = 1;
    private static final Status TASK_STATUS = Status.TODO ;
    private static final String TASK_NAME = "ExampleTask" ;

    @Autowired
    private TaskRepository taskRepository;

    /*
    @Test
    public void testUpdateTask(){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskID(TASK_ID);
        taskEntity.setTaskStatus(TASK_STATUS);
        taskEntity.setTaskName(TASK_NAME);

        taskRepository.updateTask(taskEntity.getTaskID());
        TaskEntity taskEntity1 = this.taskRepository.updateTask(taskEntity.getTaskID());
        assertEquals(taskEntity.getTaskID(), taskEntity1.getTaskID());
    }
     */
}
