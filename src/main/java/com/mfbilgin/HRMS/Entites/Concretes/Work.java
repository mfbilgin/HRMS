package com.mfbilgin.HRMS.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "works")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private int id;

    @Column(name = "company_name")
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name = "job_position")
    @NotNull
    @NotBlank
    private String jobPosition;

    @Column(name = "start_year")
    @NotNull
    private int startYear;

    @Column(name = "leave_year")
    private int leaveYear;

    @ManyToOne()
    @JoinColumn(name = "id")
    private Employer employer;

}
