package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.JobAdvertisementService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import com.mfbilgin.HRMS.DataAccess.Abstracts.JobAdvertisementDao;
import com.mfbilgin.HRMS.Entites.Concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private final JobAdvertisementDao jobAdvertisementDao;
    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        var updatedEntity = jobAdvertisementDao.getById(jobAdvertisement.getId());
        updatedEntity.setCity(jobAdvertisement.getCity());
        updatedEntity.setEmployer(jobAdvertisement.getEmployer());
        updatedEntity.setApplicationDeadline(jobAdvertisement.getApplicationDeadline());
        updatedEntity.setJobDescription(jobAdvertisement.getJobDescription());
        updatedEntity.setJobPosition(jobAdvertisement.getJobPosition());
        updatedEntity.setEmptyPositionCount(jobAdvertisement.getEmptyPositionCount());
        updatedEntity.setMaxSalary(jobAdvertisement.getMaxSalary());
        updatedEntity.setMinSalary(jobAdvertisement.getMinSalary());
        updatedEntity.setReleaseDate(jobAdvertisement.getReleaseDate());
        updatedEntity.setStatus(jobAdvertisement.isStatus());
        jobAdvertisementDao.save(updatedEntity);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(JobAdvertisement jobAdvertisement) {
        jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public Result setStatus(int id) {
        var updatedEntity = jobAdvertisementDao.getById(id);
        updatedEntity.setStatus(!updatedEntity.isStatus());
        jobAdvertisementDao.save(updatedEntity);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrue() {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByReleaseDateDesc() {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndOrderByReleaseDateDesc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByReleaseDateAsc() {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndOrderByReleaseDateAsc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineDesc() {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndOrderByApplicationDeadlineDesc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineAsc() {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndOrderByApplicationDeadlineAsc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndEmployer_Id(int employer_id) {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndEmployer_Id(employer_id));
    }
}
