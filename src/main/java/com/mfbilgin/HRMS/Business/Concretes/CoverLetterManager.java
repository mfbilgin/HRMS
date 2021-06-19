package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.CoverLetterService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.CoverLetterDao;
import com.mfbilgin.HRMS.Entites.Concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverLetterManager implements CoverLetterService {
    private final CoverLetterDao coverLetterDao;
    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao) {
        this.coverLetterDao = coverLetterDao;
    }

    @Override
    public Result add(CoverLetter coverLetter) {
        var coverLetterByEmployer_id = coverLetterDao.getByStaff_Id(coverLetter.getStaff().getId());
        if (coverLetterByEmployer_id != null) return new ErrorResult(Messages.coverLetterAlreadyExist);
        coverLetterDao.save(coverLetter);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(CoverLetter coverLetter) {
        var coverLetterById = coverLetterDao.getById(coverLetter.getId());
        coverLetterById.setContent(coverLetter.getContent());
        coverLetterDao.save(coverLetterById);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(CoverLetter coverLetter) {
        coverLetterDao.delete(coverLetter);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<CoverLetter> getByStaffId(int employer_id) {
        return new SuccessDataResult<>(coverLetterDao.getByStaff_Id(employer_id));
    }
}
