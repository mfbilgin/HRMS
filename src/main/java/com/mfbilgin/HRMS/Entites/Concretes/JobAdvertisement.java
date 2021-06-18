package com.mfbilgin.HRMS.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_advertisement_id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "job_description")
    private String jobDescription;

    @NotNull
    @Column(name = "min_salary")
    private Double minSalary;

    @NotNull
    @Column(name = "max_salary")
    private Double maxSalary;

    @NotNull
    @Column(name = "empty_position_count")
    private int emptyPositionCount;

    @NotNull
    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @NotNull
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @NotNull
    @Column(name = "status")
    private boolean status;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "id")
    private Employer employer;
}
