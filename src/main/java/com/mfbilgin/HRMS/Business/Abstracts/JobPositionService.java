package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    Result add(JobPosition jobPosition);
    Result update(JobPosition jobPosition);
    Result delete(JobPosition jobPosition);
    DataResult<List<JobPosition>> getAll();
    DataResult<JobPosition> getById(int id);
}
