package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkDao extends JpaRepository<Work,Integer> {
}
