package com.kushibrahim.taskmanagement.model.dto;

import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.enumerator.MetricType;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.Date;

@Data
public class MetricDto implements Serializable {

    private Integer metricID;

    @Enumerated(EnumType.STRING)
    private MetricType metricType;
    private Date metricStartDate;
    private Date metricOriginalEndDate;
    private Date metricActualEndDate;
    private TaskDto taskID;
}
