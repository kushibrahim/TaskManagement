package com.kushibrahim.taskmanagement.service.converter;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MetricConverter {

    public List<MetricDto> convertListMetricDto(List<MetricEntity> metricEntities) {
        if(!(metricEntities.size()>0)){
            return null;
        }
        else {
            MetricDto metricDto = new MetricDto();
            for(MetricEntity metricEntity : metricEntities){
                metricDto.setMetricID(metricEntity.getMetricID());
                metricDto.setTaskID(metricEntity.getTaskID());
                metricDto.setMetricStartDate(metricEntity.getMetricStartDate());
                metricDto.setMetricOriginalEndDate(metricEntity.getMetricOriginalEndDate());
                metricDto.setMetricActualEndDate(metricEntity.getMetricActualEndDate());
                metricDto.setMetricType(metricEntity.getMetricType().toString());

            }
            return (List<MetricDto>) metricDto;
        }
    }

    public MetricDto convertMetricDto(MetricEntity metricEntity) {
        if(metricEntity == null){
            return null;
        }
        else {
            MetricDto metricDto = new MetricDto();
            metricDto.setMetricType(metricEntity.getMetricType().toString());
            metricDto.setMetricActualEndDate(metricEntity.getMetricActualEndDate());
            metricDto.setMetricOriginalEndDate(metricEntity.getMetricOriginalEndDate());
            metricDto.setMetricStartDate(metricEntity.getMetricStartDate());
            metricDto.setTaskID(metricEntity.getTaskID());
            metricDto.setMetricType(metricEntity.getMetricType().toString());

            return metricDto;
        }
    }
}
