package com.kushibrahim.taskmanagement.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "teamlead")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TeamLeadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamleadID")
    private Integer teamLeadID;

    @Column(name = "teamLeadName")
    @NotNull(message = "Team Lead Name is a required field.")
    @Size(message = "Maximum 50 character", max = 50)
    @NotEmpty
    private String teamLeadName;

    @Column(name = "teamLeadMail")
    @NotNull(message = "Team Lead Mail is a required field.")
    @Size(message = "Maximum 50 character", max = 50)
    @NotEmpty
    @Email
    private String teamLeadMail;

    @Column(name = "teamLeadPassword")
    @NotNull(message = "Team Lead Password is a required field.")
    @Size(message = "Maximum 50 character", max = 50)
    @NotEmpty
    private String teamLeadPassword;

}
