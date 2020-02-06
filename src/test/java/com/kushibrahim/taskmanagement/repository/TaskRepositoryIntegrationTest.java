package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import com.kushibrahim.taskmanagement.repository.impl.TaskRepositoryImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@ExtendWith(SpringExtension.class)
public class TaskRepositoryIntegrationTest {

    private static final Integer TASK_ID = 1;
    private static final Status TASK_STATUS = Status.TODO ;
    private static final String TASK_NAME = "ExampleTask" ;

    @Autowired
    private TaskRepository taskRepository;


}
