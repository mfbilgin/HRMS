package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Entites.Dto.ResumeDto;

public interface ResumeService {
    DataResult<ResumeDto> getByStaffId(int staffId) ;
}
