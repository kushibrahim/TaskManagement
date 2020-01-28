package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import java.util.List;

public interface MetricService {

    List<MetricDto> getAllMetric();
    MetricDto getMetric(Integer metricId);
    MetricDto saveMetric(MetricEntity metricEntity);

}
