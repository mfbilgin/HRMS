package com.mfbilgin.HRMS.Entites.Dto;

import com.mfbilgin.HRMS.Entites.Concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
    private Staff staff;

    private LocalDate creationDate;

    private String coverLetter;

    private String githubAddress;

    private String linkedinAddress;

    private String imageUrl;

    private List<School> schools;

    private List<Work> works;

    private List<Skill> skills;

    private List<Language> languages;
}
