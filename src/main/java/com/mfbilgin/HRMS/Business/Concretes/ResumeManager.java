package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.*;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import com.mfbilgin.HRMS.Entites.Dto.ResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ResumeManager implements ResumeService {
    private final StaffService staffService;
    private final CoverLetterService coverLetterService;
    private final SkillService skillService;
    private final LanguageService languageService;
    private final SchoolService schoolService;
    private final GithubService githubService;
    private final LinkedinService linkedinService;
    private final WorkService workService;
    private final ImageService imageService;

    @Autowired
    public ResumeManager(StaffService staffService, CoverLetterService coverLetterService, SkillService skillService, LanguageService languageService, SchoolService schoolService, GithubService githubService, LinkedinService linkedinService, WorkService workService, ImageService imageService) {

        this.staffService = staffService;
        this.coverLetterService = coverLetterService;
        this.skillService = skillService;
        this.languageService = languageService;
        this.schoolService = schoolService;
        this.githubService = githubService;
        this.linkedinService = linkedinService;
        this.workService = workService;
        this.imageService = imageService;
    }
    @Override
    public DataResult<ResumeDto> getByStaffId(int staffId)  {
        var resume = new ResumeDto();
        resume.setLinkedinAddress(linkedinService.getByStaffId(staffId).getData().getAccountAddress());
        resume.setStaff(staffService.getById(staffId).getData());
        resume.setGithubAddress(githubService.getByStaffId(staffId).getData().getAccountAddress());
        resume.setImageUrl(imageService.getByStaffId(staffId).getData().getImagePath());
        resume.setCreationDate(LocalDate.now());
        resume.setLanguages(languageService.getByStaffId(staffId).getData());
        resume.setSchools(schoolService.getByStaff_IdOrderByGraduationYearDesc(staffId).getData());
        resume.setSkills(skillService.getByStaffId(staffId).getData());
        resume.setWorks(workService.getByStaff_IdOrderByLeaveYearDesc(staffId).getData());
        resume.setCoverLetter(coverLetterService.getByStaffId(staffId).getData().getContent());
        return new SuccessDataResult<>(resume);
    }

}
