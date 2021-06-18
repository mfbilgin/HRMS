package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.JobPositionService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.JobPositionDao;
import com.mfbilgin.HRMS.Entites.Concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        var result = jobPositionDao.getByName(jobPosition.getName());
        if (result != null) return new ErrorResult(Messages.jobPositionExist);
        jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(JobPosition jobPosition) {
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(jobPositionDao.findAll());
    }

    @Override
    public DataResult<JobPosition> getById(int id) {
        return new SuccessDataResult<>(this.jobPositionDao.getById(id));
    }


}
