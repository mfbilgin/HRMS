package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Entites.Concretes.WorkTime;

import java.util.List;

public interface WorkTimeService {
    DataResult<List<WorkTime>> getAll();
}
