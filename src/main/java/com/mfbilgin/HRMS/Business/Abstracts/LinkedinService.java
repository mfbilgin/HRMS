package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Linkedin;

public interface LinkedinService {
    // TODO Linkedin Operasyonlarını Yaz
    Result add(Linkedin linkedin);
    Result update(Linkedin linkedin);
    Result delete(Linkedin linkedin);
    DataResult<Linkedin> getByStaffId(int staff_id);
}
