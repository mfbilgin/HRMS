package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface WorkDao extends JpaRepository<Work,Integer> {
    List<Work> getByStaff_IdOrderByLeaveYearDesc(@NotNull @NotBlank int staff_id);
    List<Work> getByStaff_Id(@NotNull @NotBlank int staff_id);
}
