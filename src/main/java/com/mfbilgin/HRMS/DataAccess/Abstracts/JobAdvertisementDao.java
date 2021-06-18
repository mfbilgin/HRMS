package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.JobAdvertisement;
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

    @Query("From JobAdvertisement where status = true Order By applicationDeadline Asc")
    List<JobAdvertisement> getByStatusIsTrueAndOrderByApplicationDeadlineAsc();

    @Query("From JobAdvertisement where status = true and employer.id =:id")
    List<JobAdvertisement> getByStatusIsTrueAndEmployer_Id(@NotNull @NotBlank int id);


}
