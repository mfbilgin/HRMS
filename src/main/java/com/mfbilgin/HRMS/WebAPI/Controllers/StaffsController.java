package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.StaffService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Entites.Concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/staffs/")
@CrossOrigin
public class StaffsController {
    private final StaffService staffService;
    @Autowired
    public StaffsController(StaffService staffService) {
        this.staffService = staffService;

    }

    @PostMapping("add")
    private ResponseEntity<?> add(@Valid @RequestBody Staff staff){
        return ResponseEntity.ok(this.staffService.add(staff));
    }
    @PostMapping("update")
    private ResponseEntity<?> update(@Valid @RequestBody Staff staff){
        return ResponseEntity.ok(this.staffService.update(staff));
    }
    @GetMapping("getAll")
    private DataResult<List<Staff>> getAll(){
        return this.staffService.getAll();
    }
    @GetMapping("getById")
    private DataResult<Staff> getById(@RequestParam int id){
        return this.staffService.getById(id);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErrorDataResult<>(validationErrors, "Doğrulama hataları");
    }

}
