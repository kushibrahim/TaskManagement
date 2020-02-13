package com.kushibrahim.taskmanagement.model.converter;

import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
public class ProcessConverterTest {

    private ProcessConverter processConverter;

    @BeforeEach
    void setUp() {
        processConverter = new ProcessConverter();
    }

    @Test
    void convertToDtoNull(){
        final ProcessDto processDto = processConverter.convertProcessDto(null);
        assertNull(null);
    }

    @AfterEach
    void tearDown(){
        processConverter = null;
    }
}
