package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Skill;

import java.util.List;

public interface SkillService {
    Result add(Skill skill);
    Result update(Skill skill);
    Result delete(Skill skill);
    DataResult<List<Skill>> getByStaffId(int staff_id);
}
