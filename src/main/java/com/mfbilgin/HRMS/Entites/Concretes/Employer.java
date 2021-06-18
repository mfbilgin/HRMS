package com.mfbilgin.HRMS.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mfbilgin.HRMS.Core.Entites.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")

@Table(name="employers")
public class Employer extends User {

    @Column(name="company_name")
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name="web_address")
    @NotNull
    @NotBlank
    private String webAddress;

    @Column(name="phone_number")
    @NotNull
    @NotBlank
    private String phoneNumber;

    @Column(name="is_activated_by_system_staff")
    private boolean isActivatedBySystemStaff;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<School> schools;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<Work> works;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<Language> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<Github> githubs;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<Linkedin> linkedins;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<CoverLetter> coverLetters;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<Skill> skills;
}