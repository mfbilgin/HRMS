package com.mfbilgin.HRMS.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mfbilgin.HRMS.Core.Entites.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@PrimaryKeyJoinColumn(name = "id")
@Table(name="staffs")
public class Staff extends User {

    @Column(name = "first_name")
    @NotNull
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @NotBlank
    private String lastName;

    @Column(name = "identification_number")
    @NotNull
    @NotBlank
    private String identificationNumber;

    @Column(name = "birth_year")
    @NotNull
    @NotBlank
    private String birthYear;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<School> schools;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<Work> works;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<Language> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<Github> githubs;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<Linkedin> linkedins;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<CoverLetter> coverLetters;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<Skill> skills;

}
