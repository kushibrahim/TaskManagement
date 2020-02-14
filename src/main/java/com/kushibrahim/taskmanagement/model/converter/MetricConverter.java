package com.kushibrahim.taskmanagement.model.converter;

import com.kushibrahim.taskmanagement.model.dto.*;
import com.kushibrahim.taskmanagement.model.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MetricConverter {

    public List<MetricDto> convertListMetricDto(List<MetricEntity> metricEntities) {
        if (CollectionUtils.isEmpty(metricEntities)) {
            return Collections.emptyList();
        } else {
            List<MetricDto> metricDtos = new ArrayList<>();
            for (MetricEntity metricEntity : metricEntities) {
                MetricDto metricDto = new MetricDto();
                metricDto.setMetricID(metricEntity.getMetricID());
                metricDto.setTaskID(convertTaskDto(metricEntity.getTaskID()));
                metricDto.setMetricStartDate(metricEntity.getMetricStartDate());
                metricDto.setMetricOriginalEndDate(metricEntity.getMetricOriginalEndDate());
                metricDto.setMetricActualEndDate(metricEntity.getMetricActualEndDate());
                metricDto.setMetricType(metricEntity.getMetricType());

                metricDtos.add(metricDto);

            }
            return metricDtos;
        }
    }

    public MetricDto convertMetricDto(MetricEntity metricEntity) {
        if (metricEntity == null) {
            return null;
        } else {
            MetricDto metricDto = new MetricDto();
            metricDto.setMetricType(metricEntity.getMetricType());
            metricDto.setMetricActualEndDate(metricEntity.getMetricActualEndDate());
            metricDto.setMetricOriginalEndDate(metricEntity.getMetricOriginalEndDate());
            metricDto.setMetricStartDate(metricEntity.getMetricStartDate());
            metricDto.setTaskID(convertTaskDto(metricEntity.getTaskID()));
            metricDto.setMetricID(metricEntity.getMetricID());

            return metricDto;
        }
    }

    public TaskDto convertTaskDto(TaskEntity taskEntity){
        if(taskEntity == null){
            return null;
        }
        else {
            TaskDto taskDto = new TaskDto();
            taskDto.setTaskID(taskEntity.getTaskID());
            taskDto.setProcessID(convertProcessDto(taskEntity.getProcessID()));
            taskDto.setDeveloperEntityID(convertDeveloperDto(taskEntity.getDeveloperEntityID()));
            taskDto.setTaskName(taskEntity.getTaskName());
            taskDto.setTaskStatus(taskEntity.getTaskStatus());
            taskDto.setTaskActualEndDate(taskEntity.getTaskActualEndDate());
            taskDto.setTaskStartDate(taskEntity.getTaskStartDate());
            taskDto.setTaskOriginalEndDate(taskEntity.getTaskOriginalEndDate());
            taskDto.setTeamLeadEntityID(convertTeamLeadDto(taskEntity.getTeamLeadEntityID()));

            return taskDto;
        }
    }
    public ProcessDto convertProcessDto(ProcessEntity processEntity){
        if(processEntity == null){
            return null;
        }
        else {
            ProcessDto processDto = new ProcessDto();
            processDto.setProcessAssignee(processEntity.getProcessAssignee());
            processDto.setProcessAssigneer(processEntity.getProcessAssigneer());
            processDto.setProcessName(processEntity.getProcessName());
            processDto.setProcessStatus(processEntity.getProcessStatus());
            processDto.setTeamLeadID(convertTeamLeadDto(processEntity.getTeamLeadID()));
            processDto.setProcessID(processEntity.getProcessID());

            return processDto;
        }
    }

    public DeveloperDto convertDeveloperDto(DeveloperEntity developerEntity){
        if(developerEntity == null){
            return null;
        }
        else {
            DeveloperDto developerDto = new DeveloperDto();
            developerDto.setDeveloperID(developerEntity.getDeveloperID());
            developerDto.setDeveloperMail(developerEntity.getDeveloperMail());
            developerDto.setDeveloperName(developerEntity.getDeveloperName());

            return developerDto;
        }
    }

    public TeamLeadDto convertTeamLeadDto(TeamLeadEntity teamLeadEntity){
        if(teamLeadEntity == null){
            return null;
        }
        else {
            TeamLeadDto teamLeadDto = new TeamLeadDto();
            teamLeadDto.setTeamLeadID(teamLeadEntity.getTeamLeadID());
            teamLeadDto.setTeamLeadMail(teamLeadEntity.getTeamLeadMail());
            teamLeadDto.setTeamLeadName(teamLeadEntity.getTeamLeadName());

            return teamLeadDto;
        }
    }
}
