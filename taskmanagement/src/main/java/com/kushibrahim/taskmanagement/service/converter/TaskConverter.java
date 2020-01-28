package com.kushibrahim.taskmanagement.service.converter;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TaskConverter {

    public List<TaskDto> convertListTaskDto(List<TaskEntity> taskEntities){
        if(!(taskEntities.size()>0)){
            return null;
        }
        else{
            TaskDto taskDto = new TaskDto();
            for(TaskEntity taskEntity : taskEntities){
                taskDto.setTaskID(taskEntity.getTaskID());
                taskDto.setProcessID(taskEntity.getProcessID());
                taskDto.setDeveloperEntityID(taskEntity.getDeveloperEntityID());
                taskDto.setTaskName(taskEntity.getTaskName());
                taskDto.setTaskStatus(taskEntity.getTaskStatus());
                taskDto.setTeamLeadEntityID(taskEntity.getTeamLeadEntityID());
            }
            return (List<TaskDto>) taskDto;
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
