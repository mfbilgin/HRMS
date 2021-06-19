package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.LinkedinService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.LinkedinDao;
import com.mfbilgin.HRMS.Entites.Concretes.Linkedin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkedinManager implements LinkedinService {
    private final LinkedinDao linkedinDao;

    @Autowired
    public LinkedinManager(LinkedinDao linkedinDao) {
        this.linkedinDao = linkedinDao;
    }

    @Override
    public Result add(Linkedin linkedin) {
        var result = linkedinDao.getByStaff_Id(linkedin.getStaff().getId());
        if (result != null) return new ErrorResult(Messages.linkedinAlreadyExist);
        linkedinDao.save(linkedin);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Linkedin linkedin) {
        var linkedinById = linkedinDao.getById(linkedin.getId());
        linkedinById.setAccountAddress(linkedin.getAccountAddress());
        linkedinDao.save(linkedinById);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(Linkedin linkedin) {
        linkedinDao.delete(linkedin);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<Linkedin> getByStaffId(int staff_id) {
        return new SuccessDataResult<>(linkedinDao.getByStaff_Id(staff_id));
    }
}
