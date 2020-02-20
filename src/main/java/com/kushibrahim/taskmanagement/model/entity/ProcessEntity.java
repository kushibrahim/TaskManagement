package com.kushibrahim.taskmanagement.model.entity;

import com.kushibrahim.taskmanagement.model.enumerator.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "process")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ProcessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "processID")
    private Integer processID;

    @Enumerated(EnumType.STRING)
    @Column(name = "processStatus", nullable = false)
    private Status processStatus = Status.TODO;

    @Column(name = "processName")
    @NotNull(message = "Process Name is a required field.")
    @Size(message = "Maximum 50 character", max = 50)
    @NotEmpty
    private String processName;

    @Column(name = "processAssignee")
    @NotNull(message = "Process Assignee is a required field.")
    private Integer processAssignee;

    @Column(name = "processAssigneer")
    @NotNull(message = "Process Assigneer is a required field.")
    private Integer processAssigneer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamLeadID")
    private TeamLeadEntity teamLeadID;

    @OneToMany(mappedBy = "processID")
    private Set<TaskEntity> tasks;
}
