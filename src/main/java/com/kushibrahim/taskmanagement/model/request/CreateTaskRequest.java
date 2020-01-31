package com.kushibrahim.taskmanagement.model.request;

import com.kushibrahim.taskmanagement.model.entity.DeveloperEntity;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.model.entity.TeamLeadEntity;
import lombok.Data;

@Data
public class CreateTaskRequest {

    private String taskName;
    private ProcessEntity processID;
    private DeveloperEntity developerEntityID;
    private TeamLeadEntity teamLeadEntityID;
}

