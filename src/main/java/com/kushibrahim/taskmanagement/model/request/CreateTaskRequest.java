package com.kushibrahim.taskmanagement.model.request;


import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.DeveloperEntity;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.entity.TeamLeadEntity;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import com.kushibrahim.taskmanagement.repository.TaskRepository;
import com.kushibrahim.taskmanagement.service.converter.TaskConverter;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class CreateTaskRequest {

    private String taskName;
    private ProcessEntity processID;
    private DeveloperEntity developerEntityID;
    private TeamLeadEntity teamLeadEntityID;
}

