package com.kushibrahim.taskmanagement.model.dto;

import com.kushibrahim.taskmanagement.model.entity.TeamLeadEntity;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProcessDto implements Serializable {

    private Integer processID;
    private Status processStatus = Status.TODO;
    private String processName;
    private Integer processAssignee;
    private int processAssigneer;
    private TeamLeadEntity teamLeadID;
}
