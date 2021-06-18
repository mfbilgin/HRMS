package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.SystemStaffService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import com.mfbilgin.HRMS.DataAccess.Abstracts.SystemStaffDao;
import com.mfbilgin.HRMS.Entites.Concretes.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SystemStaffManager implements SystemStaffService {
    private final SystemStaffDao systemStaffDao;
    @Autowired
    public SystemStaffManager(SystemStaffDao systemStaffDao) {
        this.systemStaffDao = systemStaffDao;
    }

    @Override
    public Result add(SystemStaff systemStaff) {
        systemStaffDao.save(systemStaff);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(SystemStaff systemStaff) {
        return new SuccessResult(Messages.updated);
    }

    @Override
    public DataResult<List<SystemStaff>> getAll() {
        return new SuccessDataResult<>(systemStaffDao.findAll());
    }



    @Override
    public DataResult<SystemStaff> getById(int id) {
        return new SuccessDataResult<>(systemStaffDao.getById(id));
    }


}
