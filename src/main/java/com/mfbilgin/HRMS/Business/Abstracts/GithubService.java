package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Github;

public interface GithubService {
    Result add(Github github);
    Result update(Github github);
    Result delete(Github github);
    DataResult<Github> getByEmployerId(int employer_id);
}
