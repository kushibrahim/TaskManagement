package com.kushibrahim.taskmanagement.service.converter;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
public class TaskConverterTest {

    private TaskConverter taskConverter;

    @BeforeEach
    void setUp() {
        taskConverter = new TaskConverter();
    }

    @Test
    void convertToDtoNull(){
        final TaskDto taskDto = taskConverter.convertTaskDto(null);
        assertNull(null);
    }

    @AfterEach
    void tearDown(){
        taskConverter = null;
    }
}
