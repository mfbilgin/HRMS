package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface ImageDao extends JpaRepository<Image,Integer> {
    Image getByStaff_Id(@NotNull @NotBlank int staff_id);
}
