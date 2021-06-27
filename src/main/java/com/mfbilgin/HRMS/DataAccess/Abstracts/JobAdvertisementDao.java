package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.JobAdvertisement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    @Query("From JobAdvertisement where status = true")
    List<JobAdvertisement> getByStatusIsTrue();

    @Query("From JobAdvertisement where status = true Order By releaseDate Desc")
    List<JobAdvertisement> getByStatusIsTrueAndOrderByReleaseDateDesc();

    @Query("From JobAdvertisement where status = true Order By releaseDate Asc")
    List<JobAdvertisement> getByStatusIsTrueAndOrderByReleaseDateAsc();

    @Query("From JobAdvertisement where status = true Order By applicationDeadline Desc")
    List<JobAdvertisement> getByStatusIsTrueAndOrderByApplicationDeadlineDesc();

    @Query("From JobAdvertisement where status = true and approvedByAdmin = true Order By applicationDeadline Asc")
    List<JobAdvertisement> getByStatusIsTrueAndApprovedByAdminIsTrueOrderByApplicationDeadlineAsc(Pageable pageable);

    @Query("From JobAdvertisement where status = true and employer.id =:id")
    List<JobAdvertisement> getByStatusIsTrueAndEmployer_Id(@NotNull @NotBlank int id);

    @Query("From JobAdvertisement  where status = true and city.id =:cityId")
    List<JobAdvertisement> getByStatusIsTrueAndCity_Id(int cityId);

    @Query("From JobAdvertisement  where status = false")
    List<JobAdvertisement> getByStatusIsFalse();

    @Query("From JobAdvertisement  where status = false and employer.id =:employerId")
    List<JobAdvertisement> getByStatusIsFalseAndEmployer_Id(int employerId);

    @Query("From JobAdvertisement where status = false and id=:id")
    JobAdvertisement getByIdAndStatusIsTrue(int id);

    List<JobAdvertisement> getByStatusIsTrueAndApprovedByAdminIsFalse();

    @Query("from JobAdvertisement  where status = true and approvedByAdmin = true and city.id =:cityId and workTime.id=:workTimeId")
    List<JobAdvertisement> getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_IdAndWorkTime_Id(int cityId,int workTimeId);

    @Query("from JobAdvertisement  where status = true and approvedByAdmin = true and city.id =:cityId")
    List<JobAdvertisement> getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_Id(int cityId);

    @Query("from JobAdvertisement  where status = true and approvedByAdmin = true and workTime.id=:workTimeId")
    List<JobAdvertisement> getByStatusIsTrueAndApprovedByAdminIsTrueAndWorkTime_Id(int workTimeId);
}
