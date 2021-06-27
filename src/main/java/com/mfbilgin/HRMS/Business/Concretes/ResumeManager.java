package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.*;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.Staff;
import com.mfbilgin.HRMS.Entites.Dto.ResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public DataResult<ResumeDto> getByStaffId(int staffId) {
        var resume = new ResumeDto();
        if (!checkIfValueNotNull(staffId)) {
            return new ErrorDataResult<>(null,"En az bir veri eksik");
        }
        resume.setLinkedinAddress(linkedinService.getByStaffId(staffId).getData().getAccountAddress());
        resume.setStaff(staffService.getById(staffId).getData());
        resume.setGithubAddress(githubService.getByStaffId(staffId).getData().getAccountAddress());
        resume.setImageUrl(imageService.getByStaffId(staffId).getData().getImagePath());
        resume.setCreationDate(LocalDate.now());
        resume.setLanguages(languageService.getByStaffIdOrderByLevelDesc(staffId).getData());
        resume.setSchools(schoolService.getByStaff_IdOrderByGraduationYearDesc(staffId).getData());
        resume.setSkills(skillService.getByStaffId(staffId).getData());
        resume.setWorks(workService.getByStaff_IdOrderByLeaveYearDesc(staffId).getData());
        resume.setCoverLetter(coverLetterService.getByStaffId(staffId).getData().getContent());
        return new SuccessDataResult<>(resume);
    }

    private boolean checkIfValueNotNull(int staffId) {
        if (linkedinService.getByStaffId(staffId).getData() != null)
            if (staffService.getById(staffId).getData() != null)
                if (githubService.getByStaffId(staffId).getData() != null)
                    if (imageService.getByStaffId(staffId).getData() != null)
                        if (languageService.getByStaffIdOrderByLevelDesc(staffId).getData() != null)
                            if (schoolService.getByStaff_IdOrderByGraduationYearDesc(staffId).getData() != null)
                                if (skillService.getByStaffId(staffId).getData() != null)
                                    if (workService.getByStaff_IdOrderByLeaveYearDesc(staffId).getData() != null)
                                        if (coverLetterService.getByStaffId(staffId).getData() != null) return true;
        return false;
    }

    @Override
    public DataResult<List<ResumeDto>> getAll() {
        return new SuccessDataResult<>(getAllResumes());
    }

    private List<ResumeDto> getAllResumes() {
        List<ResumeDto> resumeDtos = new ArrayList<>();
        var staffs = staffService.getAll().getData();
        for (Staff staff : staffs) {
            var result = getByStaffId(staff.getId()).getData();
            if (result != null) {
                resumeDtos.add(result);
            }
        }
        return resumeDtos;
    }
}
