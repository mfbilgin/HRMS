package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.LanguageService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.LanguageDao;
import com.mfbilgin.HRMS.Entites.Concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private final LanguageDao languageDao;
    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        languageDao.save(language);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Language language) {
        var languageById = languageDao.getById(language.getId());
        languageById.setLevel(language.getLevel());
        languageById.setName(language.getName());
        languageDao.save(languageById);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(Language language) {
        languageDao.delete(language);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<Language>> getByStaffId(int employer_id) {
        return new SuccessDataResult<>(languageDao.getByStaff_Id(employer_id));
    }
}
