package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Work;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface WorkService {
    Result add(Work work);
    Result update(Work work);
    Result delete(Work work);
    DataResult<List<Work>> getByStaffId(int staff_id);
    DataResult<List<Work>> getByStaff_IdOrderByLeaveYearDesc(int staff_id);

}
