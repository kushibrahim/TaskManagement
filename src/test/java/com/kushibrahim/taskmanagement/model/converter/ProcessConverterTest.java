package com.kushibrahim.taskmanagement.model.converter;

import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void convertDtoTest(){
        ProcessEntity processEntity = new ProcessEntity();
        processEntity.setProcessName("EXAMPLE");
        processEntity.setProcessStatus(Status.TODO);
        processEntity.setProcessAssignee(1);
        processEntity.setProcessAssigneer(1);
        processEntity.setProcessID(1);

        ProcessDto processDto = new ProcessDto();
        processDto.setProcessName("EXAMPLE");
        processDto.setProcessStatus(Status.TODO);
        processDto.setProcessAssignee(1);
        processDto.setProcessAssigneer(1);
        processDto.setProcessID(1);

        ProcessDto processNewDto = processConverter.convertProcessDto(processEntity);

        assertEquals(processNewDto.getProcessName(), processDto.getProcessName());
        assertEquals(processNewDto.getProcessStatus(), processDto.getProcessStatus());
        assertEquals(processNewDto.getProcessAssignee(), processDto.getProcessAssignee());
        assertEquals(processNewDto.getProcessAssigneer(), processDto.getProcessAssigneer());
        assertEquals(processNewDto.getProcessID(), processDto.getProcessID());

    }

    @AfterEach
    void tearDown(){
        processConverter = null;
    }
}
