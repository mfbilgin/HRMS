package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Entites.Concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
    JobPosition getByName(@NotBlank @NotNull @Min(value = 2, message = Messages.jobPositionNameLengthMustBeGreaterThanOne) String name);
}

