package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import java.util.List;

public interface MetricService {

    List<MetricDto> getAllMetric();
    MetricDto getMetricById(Integer metricId);
    MetricDto saveMetric(Integer metricId);

}
