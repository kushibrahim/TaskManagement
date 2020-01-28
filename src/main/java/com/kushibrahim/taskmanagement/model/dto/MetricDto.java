package com.kushibrahim.taskmanagement.model.dto;

import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import lombok.Data;
import java.util.Date;

@Data
public class MetricDto {

    private Integer metricID;
    private String metricType;
    private Date metricStartDate;
    private Date metricOriginalEndDate;
    private Date metricActualEndDate;
    private TaskEntity taskID;
}
