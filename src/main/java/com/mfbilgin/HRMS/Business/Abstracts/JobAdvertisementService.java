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
    DataResult<List<JobAdvertisement>> getByStatusIsTrue();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByReleaseDateDesc();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByReleaseDateAsc();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineDesc();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineAsc();
    DataResult<List<JobAdvertisement>> getByStatusIsTrueAndEmployer_Id(@NotNull @NotBlank int employer_id);
}
