package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
}
