package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Staff;

import java.util.List;

public interface StaffService {
    Result add(Staff staff);
    Result update(Staff staff);
    DataResult<List<Staff>> getAll();
    DataResult<Staff> getById(int id);
    DataResult<Staff> getByIdentificationNumber(String identificationNumber);
}
