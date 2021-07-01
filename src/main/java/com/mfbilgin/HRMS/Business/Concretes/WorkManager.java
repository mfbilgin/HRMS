package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.WorkService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import com.mfbilgin.HRMS.DataAccess.Abstracts.WorkDao;
import com.mfbilgin.HRMS.Entites.Concretes.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkManager implements WorkService {
    private final WorkDao workDao;
    @Autowired
    public WorkManager(WorkDao workDao) {
        this.workDao = workDao;
    }

    @Override
    public Result add(Work work) {
        if(work.getLeaveYear().equals("") ||work.getLeaveYear().equals("0")){
            work.setLeaveYear("Devam ediyor");
        }
        workDao.save(work);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Work work) {
        var workById = workDao.getById(work.getWorkId());
        workById.setCompanyName(work.getCompanyName());
        workById.setJobPosition(work.getJobPosition());
        workById.setStartYear(work.getStartYear());
        if (work.getLeaveYear().equals("") ||work.getLeaveYear().equals("0")){
            workById.setLeaveYear("Devam ediyor");
        }else {
            workById.setLeaveYear(work.getLeaveYear());
        }
        workDao.save(workById);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(int workId) {
        var work = workDao.getById(workId);
        workDao.delete(work);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<Work> getById(int id) {
        return new SuccessDataResult<>(workDao.getById(id));
    }

    @Override
    public DataResult<List<Work>> getByStaffId(int staff_id) {
        return new SuccessDataResult<>(workDao.getByStaff_Id(staff_id));
    }

    @Override
    public DataResult<List<Work>> getByStaff_IdOrderByLeaveYearDesc(int staff_id) {
        return new SuccessDataResult<>(workDao.getByStaff_IdOrderByLeaveYearDesc(staff_id));
    }


}
