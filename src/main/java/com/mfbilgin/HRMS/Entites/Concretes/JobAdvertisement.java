package com.mfbilgin.HRMS.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers","favorites"})
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

    @Column(name = "min_salary")
    private Double minSalary;

    @Column(name = "max_salary")
    private Double maxSalary;

    @NotNull
    @Column(name = "empty_position_count")
    private int emptyPositionCount;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @NotNull
    @Column(name = "status")
    private boolean status;

    @NotNull
    @Column(name = "approved_by_system_staff")
    private boolean approvedByAdmin;

    @ManyToOne()
    @NotNull
    @JoinColumn(name = "city_id")
    private City city;


    @ManyToOne()
    @NotNull
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;


    @ManyToOne()
    @NotNull
    @JoinColumn(name = "id")
    private Employer employer;

    @ManyToOne()
    @NotNull
    @JoinColumn(name = "work_type_id")
    private WorkType workType;

    @ManyToOne()
    @NotNull
    @JoinColumn(name = "work_time_id")
    private WorkTime workTime;


    @OneToMany(mappedBy = "jobAdvertisement")
    @JsonIgnore
    private List<Favorite> favorites;
}
