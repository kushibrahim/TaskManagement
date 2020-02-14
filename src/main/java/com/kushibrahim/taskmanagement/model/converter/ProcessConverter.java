package com.kushibrahim.taskmanagement.model.converter;

import com.kushibrahim.taskmanagement.model.dto.DeveloperDto;
import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.dto.TeamLeadDto;
import com.kushibrahim.taskmanagement.model.entity.DeveloperEntity;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.entity.TeamLeadEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProcessConverter {

    public List<ProcessDto> convertListProcessDto(List<ProcessEntity> processEntities) {
        if (CollectionUtils.isEmpty(processEntities)) {
            return Collections.emptyList();
        } else {
            List<ProcessDto> processDtos = new ArrayList<>();
            for (ProcessEntity processEntity : processEntities) {
                ProcessDto processDto = new ProcessDto();
                processDto.setProcessID(processEntity.getProcessID());
                processDto.setProcessAssignee(processEntity.getProcessAssignee());
                processDto.setProcessAssigneer(processEntity.getProcessAssigneer());
                processDto.setProcessName(processEntity.getProcessName());
                processDto.setProcessStatus(processEntity.getProcessStatus());
                processDto.setTeamLeadID(convertTeamLeadDto(processEntity.getTeamLeadID()));

                processDtos.add(processDto);
            }
            return processDtos;
        }
    }

    public ProcessDto convertProcessDto(ProcessEntity processEntity){
        if(processEntity == null){
            return null;
        }
        else {
            ProcessDto processDto = new ProcessDto();
            processDto.setProcessID(processEntity.getProcessID());
            processDto.setTeamLeadID(convertTeamLeadDto(processEntity.getTeamLeadID()));
            processDto.setProcessStatus(processEntity.getProcessStatus());
            processDto.setProcessName(processEntity.getProcessName());
            processDto.setProcessAssigneer(processEntity.getProcessAssigneer());
            processDto.setProcessAssignee(processEntity.getProcessAssignee());

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

    public TaskDto convertTaskDto(TaskEntity taskEntity){
        if(taskEntity == null){
            return null;
        }
        else {
            TaskDto taskDto = new TaskDto();
            taskDto.setTaskID(taskEntity.getTaskID());
            taskDto.setTaskOriginalEndDate(taskEntity.getTaskOriginalEndDate());
            taskDto.setTaskStartDate(taskEntity.getTaskStartDate());
            taskDto.setTaskActualEndDate(taskEntity.getTaskActualEndDate());
            taskDto.setTaskStatus(taskEntity.getTaskStatus());
            taskDto.setTaskName(taskEntity.getTaskName());
            taskDto.setDeveloperEntityID(convertDeveloperDto(taskEntity.getDeveloperEntityID()));
            taskDto.setProcessID(convertProcessDto(taskEntity.getProcessID()));
            taskDto.setTeamLeadEntityID(convertTeamLeadDto(taskEntity.getTeamLeadEntityID()));

            return taskDto;
        }
    }

}

