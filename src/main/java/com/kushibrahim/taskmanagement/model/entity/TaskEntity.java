package com.kushibrahim.taskmanagement.model.entity;

import com.kushibrahim.taskmanagement.model.enumerator.Status;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskID;

    @Column(name = "taskName")
    @NotNull(message = "Task Name is a required field.")
    @Size(message = "Maximum 50 character", max = 50)
    @NotEmpty
    private String taskName;

    @Enumerated(EnumType.STRING)
    @Column(name = "taskStatus", nullable = false)
    private Status taskStatus = Status.TODO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processID")
    private ProcessEntity processID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developerID")
    private DeveloperEntity developerEntityID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamLeadID")
    private TeamLeadEntity teamLeadEntityID;
}
