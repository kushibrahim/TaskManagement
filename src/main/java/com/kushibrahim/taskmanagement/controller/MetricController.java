package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import com.kushibrahim.taskmanagement.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metric")
public class MetricController {

    private final MetricService metricService;

    @Autowired
    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping
    public ResponseEntity<List<MetricDto>> getAllMetric(){
        return metricService.getAllMetric();
    }

    @GetMapping("/{metricId}")
    public ResponseEntity<MetricDto> getMetricById(@PathVariable Integer metricId){
         return metricService.getMetric(metricId);
    }

    @PostMapping("/saveMetric")
    public ResponseEntity<MetricDto> saveMetric(@RequestBody MetricEntity metricEntity) {
        return metricService.saveMetric(metricEntity);
    }

}
