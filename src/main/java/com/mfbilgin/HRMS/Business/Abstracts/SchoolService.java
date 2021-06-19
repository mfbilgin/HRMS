package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Linkedin;
import com.mfbilgin.HRMS.Entites.Concretes.School;
import com.mfbilgin.HRMS.Entites.Concretes.Work;

import java.util.List;

public interface SchoolService {
    Result add(School school);
    Result update(School school);
    Result delete(School school);
    DataResult<List<School>> getByStaffId(int staff_id);
    DataResult<List<School>> getByStaff_IdOrderByGraduationYearDesc(int staff_id);
}
