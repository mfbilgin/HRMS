package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Entites.Dto.ResumeDto;

import java.util.List;

public interface ResumeService {
    DataResult<ResumeDto> getByStaffId(int staffId) ;
    DataResult<List<ResumeDto>> getAll() ;
}
