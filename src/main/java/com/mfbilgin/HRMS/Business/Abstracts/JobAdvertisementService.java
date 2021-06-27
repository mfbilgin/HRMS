package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    Result update(JobAdvertisement jobAdvertisement);
    Result delete(JobAdvertisement jobAdvertisement);
    Result setStatus(int id);
    Result approveJobAdvertisement(int jobAdvertisementId);
    DataResult<List<JobAdvertisement>> getByStatusIsTrue();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByReleaseDateDesc();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByReleaseDateAsc();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineDesc();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineAsc(int pageNo,int pageSize);
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndEmployer_Id(@NotNull @NotBlank int employer_id);
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndCity_Id(int cityId);
    DataResult<List<JobAdvertisement>> getByStatusIsFalseAndEmployer_Id(int employerId);
    DataResult<List<JobAdvertisement>> getByStatusIsFalse();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsFalse();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_IdAndWorkTime_Id(int cityId,int workTimeId);
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_Id(int cityId);
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsTrueAndWorkTime_Id(int workTimeId);
    DataResult<JobAdvertisement> getById(int id);
    DataResult<JobAdvertisement> getByIdAndStatusIsTrue(int id);

    DataResult<Integer> getPageCount(int pageSize);

}
