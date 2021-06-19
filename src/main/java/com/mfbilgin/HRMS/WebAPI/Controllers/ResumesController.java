package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.ResumeService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Entites.Dto.ResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resumes/")
@CrossOrigin
public class ResumesController {
    private final ResumeService resumeService;
    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/getByStaffId")
    public DataResult<ResumeDto> getByStaffId(@RequestParam int staffId) {
        return this.resumeService.getByStaffId(staffId);
    }
}
