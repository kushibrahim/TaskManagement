package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import com.kushibrahim.taskmanagement.service.MetricService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metric")
public class MetricController {

    private final MetricService metricService;

    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping
    public List<MetricEntity> getAllMetric(){
    }

    @GetMapping("/{metricId}")
    public MetricEntity getMetricById(@PathVariable Integer metricId){
    }

    @PostMapping("/{metricId}")
    public void addMetric(@PathVariable Integer metricId){
        metricService.addMetric(metricId);
    }

}
