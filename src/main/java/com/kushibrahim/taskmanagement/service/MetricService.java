package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MetricService {

    ResponseEntity<List<MetricDto>> getAllMetric();
    ResponseEntity<MetricDto> getMetric(Integer metricId);
    ResponseEntity<MetricDto> saveMetric(MetricEntity metricEntity);

}
