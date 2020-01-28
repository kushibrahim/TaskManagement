package com.kushibrahim.taskmanagement.model.dto;

import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class MetricDto {

    private Integer metricID;

    @Enumerated(EnumType.STRING)
    private String metricType;
    private Date metricStartDate;
    private Date metricOriginalEndDate;
    private Date metricActualEndDate;
    private TaskEntity taskID;
}
