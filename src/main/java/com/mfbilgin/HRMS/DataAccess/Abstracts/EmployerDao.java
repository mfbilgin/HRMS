package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {

}