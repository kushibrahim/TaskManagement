package com.kushibrahim.taskmanagement.model.dto;

import com.kushibrahim.taskmanagement.model.entity.*;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TaskDto implements Serializable {

    private Integer taskID;
    private String taskName;
    private Status taskStatus = Status.TODO;
    private Date taskStartDate;
    private Date taskOriginalEndDate;
    private Date taskActualEndDate;
    private ProcessDto processID;
    private DeveloperDto developerEntityID;
    private TeamLeadDto teamLeadEntityID;
}
