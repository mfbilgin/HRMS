package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Employer;
import com.mfbilgin.HRMS.Entites.Concretes.EmployerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate,Integer> {
    EmployerUpdate getByEmployer_Id(@NotNull int employer_id);
}
