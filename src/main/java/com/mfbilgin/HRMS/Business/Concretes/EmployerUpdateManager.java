package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.EmployerUpdateService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import com.mfbilgin.HRMS.DataAccess.Abstracts.EmployerUpdateDao;
import com.mfbilgin.HRMS.Entites.Concretes.EmployerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerUpdateManager implements EmployerUpdateService {
    private final EmployerUpdateDao employerUpdateDao;
    @Autowired
    public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao) {
        this.employerUpdateDao = employerUpdateDao;
    }

    @Override
    public Result add(EmployerUpdate employerUpdate) {
        employerUpdateDao.save(employerUpdate);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result delete(int id) {
        var employerUpdate = employerUpdateDao.getById(id);
        employerUpdateDao.delete(employerUpdate);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<EmployerUpdate> getByEmployer_Id(int employerId) {
        return new SuccessDataResult<>(employerUpdateDao.getByEmployer_Id(employerId));
    }

    @Override
    public DataResult<List<EmployerUpdate>> getAll() {
        return new SuccessDataResult<>(employerUpdateDao.findAll());
    }
}
