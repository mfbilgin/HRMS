package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Entites.Concretes.WorkType;

import java.util.List;

public interface WorkTypeService {
    DataResult<List<WorkType>> getAll();
}
