package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.CityService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.CityDao;
import com.mfbilgin.HRMS.Entites.Concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private final CityDao cityDao;
    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
        var cityGetByName = cityDao.getByName(city.getName());
        if (cityGetByName != null) return new ErrorResult(Messages.cityAlreadyExist);
        cityDao.save(city);
        return new SuccessResult(city.getName() +" "+ Messages.added);
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<>(cityDao.getAllByOrderByNameAsc());
    }
}
