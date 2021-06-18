package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Entites.Concretes.SystemStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface SystemStaffDao extends JpaRepository<SystemStaff,Integer> {
}
