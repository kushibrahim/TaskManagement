package com.kushibrahim.taskmanagement.service.converter;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
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
                taskDto.setProcessID(taskEntity.getProcessID());
                taskDto.setDeveloperEntityID(taskEntity.getDeveloperEntityID());
                taskDto.setTaskName(taskEntity.getTaskName());
                taskDto.setTaskStatus(taskEntity.getTaskStatus());
                taskDto.setTeamLeadEntityID(taskEntity.getTeamLeadEntityID());

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
            taskDto.setProcessID(taskEntity.getProcessID());
            taskDto.setDeveloperEntityID(taskEntity.getDeveloperEntityID());
            taskDto.setTaskName(taskEntity.getTaskName());
            taskDto.setTaskStatus(taskEntity.getTaskStatus());
            taskDto.setTeamLeadEntityID(taskEntity.getTeamLeadEntityID());

            return taskDto;
        }
    }
}
