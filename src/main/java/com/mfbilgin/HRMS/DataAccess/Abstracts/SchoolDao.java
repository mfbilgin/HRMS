package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface SchoolDao extends JpaRepository<School,Integer> {

    List<School> getByStaff_IdOrderByGraduationYearDesc(@NotNull @NotBlank int staff_id);
    List<School> getByStaff_Id(@NotNull @NotBlank int staff_id);
}
