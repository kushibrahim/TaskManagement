package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.base.BaseControllerTest;
import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.repository.impl.TaskRepositoryImpl;
import com.kushibrahim.taskmanagement.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(value = TaskController.class)
public class TaskControllerTest extends BaseControllerTest {

    private static final Integer TASK_ID = 1;

    private TaskDto taskDto;

    @MockBean
    private TaskServiceImpl taskService;

}
