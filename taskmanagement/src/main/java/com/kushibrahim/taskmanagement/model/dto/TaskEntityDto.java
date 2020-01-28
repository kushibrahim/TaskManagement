package com.kushibrahim.taskmanagement.model.dto;

import com.kushibrahim.taskmanagement.model.entity.*;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import lombok.Data;

@Data
public class TaskEntityDto {

    private Integer taskID;
    private String taskName;
    private Status taskStatus = Status.TODO;
    private ProcessEntity processID;
    private DeveloperEntity developerEntityID;
    private TeamLeadEntity teamLeadEntityID;
}
