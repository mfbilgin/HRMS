package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.CoverLetter;

import java.util.List;

public interface CoverLetterService {
    Result add(CoverLetter coverLetter);
    Result update(CoverLetter coverLetter);
    Result delete(CoverLetter coverLetter);
    DataResult<CoverLetter> getByEmployerId(int employer_id);
}
