package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.SystemStaff;

import java.util.List;

public interface SystemStaffService {
    Result add(SystemStaff systemStaff);
    Result update(SystemStaff systemStaff);
    DataResult<List<SystemStaff>> getAll();
    DataResult<SystemStaff> getById(int id);

}
