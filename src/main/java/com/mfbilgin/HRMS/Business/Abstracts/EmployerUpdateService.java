package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.EmployerUpdate;

import java.util.List;

public interface EmployerUpdateService {
    Result add(EmployerUpdate employerUpdate);
    Result delete(int id);
    DataResult<EmployerUpdate> getByEmployer_Id(int employerId);
    DataResult<List<EmployerUpdate>> getAll();
}
