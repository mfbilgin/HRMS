package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Linkedin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkedinDao  extends JpaRepository<Linkedin,Integer> {
}
