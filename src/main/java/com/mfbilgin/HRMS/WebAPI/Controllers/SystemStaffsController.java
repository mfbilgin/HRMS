package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.SystemStaffService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/systemStaffs/")
@CrossOrigin
public class SystemStaffsController {
    private final SystemStaffService systemStaffService;
    @Autowired
    public SystemStaffsController(SystemStaffService systemStaffService) {
        this.systemStaffService = systemStaffService;

    }

    @PostMapping("add")
    private ResponseEntity<?> add(@Valid @RequestBody SystemStaff systemStaff){
        return ResponseEntity.ok(this.systemStaffService.add(systemStaff));
    }
    @PostMapping("update")
    private ResponseEntity<?> update(@Valid @RequestBody SystemStaff systemStaff){
        return ResponseEntity.ok(this.systemStaffService.update(systemStaff));
    }
    @GetMapping("getAll")
    private DataResult<List<SystemStaff>> getAll(){
        return this.systemStaffService.getAll();
    }
    @GetMapping("getById")
    private DataResult<SystemStaff> getById(@RequestParam int id){
        return this.systemStaffService.getById(id);
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
