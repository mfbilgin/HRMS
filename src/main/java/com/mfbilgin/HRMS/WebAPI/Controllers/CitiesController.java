package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.CityService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Entites.Concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities/")
@CrossOrigin
public class CitiesController {
    private final CityService cityService;
    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("getAll")
    private DataResult<List<City>> getAll(){
        return this.cityService.getAll();
    }
}
