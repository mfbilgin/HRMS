package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.JobAdvertisementService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.JobAdvertisementDao;
import com.mfbilgin.HRMS.Entites.Concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        jobAdvertisement.setStatus(true);
        jobAdvertisement.setApprovedByAdmin(false);
        jobAdvertisement.setReleaseDate(LocalDate.now());
        jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.jobAdvertisementAdded);
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
        if (updatedEntity.getApplicationDeadline().getDayOfYear() < LocalDate.now().getDayOfYear()) return new ErrorResult(Messages.applicationDeadlineWasExpired);
        updatedEntity.setStatus(!updatedEntity.isStatus());
        jobAdvertisementDao.save(updatedEntity);
        return new SuccessResult();
    }

    @Override
    public Result approveJobAdvertisement(int jobAdvertisementId) {
        var jobAdvertisement = jobAdvertisementDao.getById(jobAdvertisementId);
        jobAdvertisement.setApprovedByAdmin(true);
        jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İş ilanı onaylandı");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrue() {
        var resultForCheck = jobAdvertisementDao.getByStatusIsTrue();
        SetIfApplicationDeadlineHasExpired(resultForCheck);
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByReleaseDateDesc() {
        var resultForCheck = jobAdvertisementDao.getByStatusIsTrueAndOrderByReleaseDateDesc();
        SetIfApplicationDeadlineHasExpired(resultForCheck);
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndOrderByReleaseDateDesc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByReleaseDateAsc() {
        var resultForCheck = jobAdvertisementDao.getByStatusIsTrueAndOrderByReleaseDateAsc();
        SetIfApplicationDeadlineHasExpired(resultForCheck);
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndOrderByReleaseDateAsc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineDesc() {
        var resultForCheck = jobAdvertisementDao.getByStatusIsTrueAndOrderByApplicationDeadlineDesc();
        SetIfApplicationDeadlineHasExpired(resultForCheck);
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndOrderByApplicationDeadlineDesc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineAsc(int pageNo,int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        var resultForCheck = jobAdvertisementDao.getByStatusIsTrueAndApprovedByAdminIsTrueOrderByApplicationDeadlineAsc(pageable);
        SetIfApplicationDeadlineHasExpired(resultForCheck);
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndApprovedByAdminIsTrueOrderByApplicationDeadlineAsc(pageable));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndEmployer_Id(int employer_id) {
        var resultForCheck = jobAdvertisementDao.getByStatusIsTrueAndEmployer_Id(employer_id);
        SetIfApplicationDeadlineHasExpired(resultForCheck);
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndEmployer_Id(employer_id));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndCity_Id(int cityId) {
        var resultForCheck = jobAdvertisementDao.getByStatusIsTrueAndCity_Id(cityId);
        SetIfApplicationDeadlineHasExpired(resultForCheck);
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndCity_Id(cityId));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsFalseAndEmployer_Id(int employerId) {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsFalseAndEmployer_Id(employerId));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsFalse() {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsFalse());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsFalse() {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndApprovedByAdminIsFalse());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_IdAndWorkTime_Id(int cityId, int workTimeId) {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_IdAndWorkTime_Id(cityId,workTimeId));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_Id(int cityId) {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_Id(cityId));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsTrueAndWorkTime_Id(int workTimeId) {
        return new SuccessDataResult<>(jobAdvertisementDao.getByStatusIsTrueAndApprovedByAdminIsTrueAndWorkTime_Id(workTimeId));
    }

    @Override
    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<>(jobAdvertisementDao.getById(id));
    }

    @Override
    public DataResult<JobAdvertisement> getByIdAndStatusIsTrue(int id) {
        return new SuccessDataResult<>(jobAdvertisementDao.getByIdAndStatusIsTrue(id));
    }

    @Override
    public DataResult<Integer> getPageCount(int pageSize) {
        int pageCount = (int) Math.ceil((double)jobAdvertisementDao.count() / pageSize);
        return new SuccessDataResult<>(pageCount);
    }

    private void SetIfApplicationDeadlineHasExpired(List<JobAdvertisement> jobAdvertisements){
        for (JobAdvertisement jobAdvertisement: jobAdvertisements) {
            if (jobAdvertisement.getApplicationDeadline().getDayOfYear() < LocalDate.now().getDayOfYear()){
                setStatus(jobAdvertisement.getId());
            }
        }
    }
}
