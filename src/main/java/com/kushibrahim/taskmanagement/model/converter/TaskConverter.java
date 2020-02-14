package com.kushibrahim.taskmanagement.model.converter;

import com.kushibrahim.taskmanagement.model.dto.DeveloperDto;
import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.dto.TeamLeadDto;
import com.kushibrahim.taskmanagement.model.entity.DeveloperEntity;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.entity.TeamLeadEntity;
import com.kushibrahim.taskmanagement.model.request.CreateTaskRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class TaskConverter {

    public List<TaskDto> convertListTaskDto(List<TaskEntity> taskEntities){
        if(CollectionUtils.isEmpty(taskEntities)){
            return Collections.emptyList();
        } else{
            List<TaskDto> taskDtos = new ArrayList<>();
            for(TaskEntity taskEntity : taskEntities){
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

                taskDtos.add(taskDto);
            }
            return taskDtos;
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

    public TaskEntity convertTaskEntity(CreateTaskRequest request){
        if(request == null){
            return null;
        }
        else {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTaskName(request.getTaskName());
            taskEntity.setDeveloperEntityID(request.getDeveloperEntityID());
            taskEntity.setProcessID(request.getProcessID());
            taskEntity.setTeamLeadEntityID(request.getTeamLeadEntityID());

            return taskEntity;
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
