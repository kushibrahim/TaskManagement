package com.kushibrahim.taskmanagement.service.converter;

import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProcessConverter {

    public List<ProcessDto> convertListProcessDto(List<ProcessEntity> processEntities){
        if(!(processEntities.size()>0)){
            return null;
        }
        else{
            ProcessDto processDto = new ProcessDto();
            for(ProcessEntity processEntity : processEntities){
                processDto.setProcessID(processEntity.getProcessID());
                processDto.setProcessAssignee(processEntity.getProcessAssignee());
                processDto.setProcessAssigneer(processEntity.getProcessAssigneer());
                processDto.setProcessName(processEntity.getProcessName());
                processDto.setProcessStatus(processEntity.getProcessStatus());
                processDto.setTeamLeadID(processEntity.getTeamLeadID());

            }
            return (List<ProcessDto>) processDto;
        }
    }

    public ProcessDto convertProcessDto(ProcessEntity processEntity){
        if(processEntity == null){
            return null;
        }
        else {
            ProcessDto processDto = new ProcessDto();
            processDto.setProcessID(processEntity.getProcessID());
            processDto.setTeamLeadID(processEntity.getTeamLeadID());
            processDto.setProcessStatus(processEntity.getProcessStatus());
            processDto.setProcessName(processEntity.getProcessName());
            processDto.setProcessAssigneer(processEntity.getProcessAssigneer());
            processDto.setProcessAssignee(processEntity.getProcessAssignee());

            return processDto;
        }
    }
}
