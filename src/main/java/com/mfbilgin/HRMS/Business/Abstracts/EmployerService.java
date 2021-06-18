package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Employer;

import java.util.List;

public interface EmployerService {
    Result add(Employer employer);
    Result update(Employer employer);
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
}
