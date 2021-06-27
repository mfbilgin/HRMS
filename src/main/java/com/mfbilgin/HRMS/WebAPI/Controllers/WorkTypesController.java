package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.WorkTypeService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Entites.Concretes.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workTypes/")
@CrossOrigin
public class WorkTypesController {
    private final WorkTypeService workTypeService;
    @Autowired
    public WorkTypesController(WorkTypeService workTypeService) {
        this.workTypeService = workTypeService;
    }

    @GetMapping("getAll")
    public DataResult<List<WorkType>> getAll(){
        return workTypeService.getAll();
    }
}
