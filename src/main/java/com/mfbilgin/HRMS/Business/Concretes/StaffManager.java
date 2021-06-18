package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.StaffService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import com.mfbilgin.HRMS.DataAccess.Abstracts.StaffDao;
import com.mfbilgin.HRMS.Entites.Concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffManager implements StaffService {
    private final StaffDao staffDao;

    @Autowired
    public StaffManager(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public Result add(Staff staff) {
        staffDao.save(staff);
        return new SuccessResult();
    }

    @Override
    public Result update(Staff staff) {
        var staffById = staffDao.getById(staff.getId());
        staffById.setBirthYear(staff.getBirthYear());
        staffById.setLastName(staff.getLastName());
        staffById.setIdentificationNumber(staff.getIdentificationNumber());
        staffById.setFirstName(staff.getFirstName());
        staffById.setEmail(staff.getEmail());
        staffById.setPassword(staff.getPassword());
        staffDao.save(staffById);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public DataResult<List<Staff>> getAll() {
        return new SuccessDataResult<>(staffDao.findAll());
    }



    @Override
    public DataResult<Staff> getById(int id) {
        return new SuccessDataResult<>(staffDao.getById(id));
    }

    @Override
    public DataResult<Staff> getByIdentificationNumber(String identificationNumber) {
        return new SuccessDataResult<>(staffDao.getByIdentificationNumber(identificationNumber));
    }


}
