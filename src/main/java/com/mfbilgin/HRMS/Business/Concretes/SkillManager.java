package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.SkillService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.SkillDao;
import com.mfbilgin.HRMS.Entites.Concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkillManager implements SkillService {
    private final SkillDao skillDao;
    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public Result add(Skill skill) {
        var result = skillDao.getByStaff_IdAndAndName(skill.getStaff().getId(),skill.getName());
        if (result != null) return new ErrorResult(Messages.skillAlreadyExist);
        skillDao.save(skill);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Skill skill) {
        var skillById = skillDao.getById(skill.getId());
        skillById.setName(skill.getName());
        skillDao.save(skillById);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(Skill skill) {
        skillDao.delete(skill);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<Skill>> getByStaffId(int staff_id) {
        return new SuccessDataResult<>(skillDao.getByStaff_Id(staff_id));
    }
}
