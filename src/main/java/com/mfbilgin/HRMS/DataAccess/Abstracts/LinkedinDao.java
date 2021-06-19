package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Linkedin;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface LinkedinDao  extends JpaRepository<Linkedin,Integer> {
    Linkedin getByStaff_Id(@NotNull @NotBlank int staff_id);
}
