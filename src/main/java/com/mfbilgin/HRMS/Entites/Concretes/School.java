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
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private int id;

    @Column(name = "school_name")
    @NotNull
    @NotBlank
    private String schoolName;

    @Column(name = "department")
    @NotNull
    @NotBlank
    private String department;

    @Column(name = "start_year")
    @NotNull
    private int startYear;

    @Column(name = "graduation_year")
    private int graduationYear;


    @ManyToOne()
    @JoinColumn(name = "id")
    private Employer employer;
}
