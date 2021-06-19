package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.SchoolService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.School;
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
@RequestMapping("/api/schools/")
@CrossOrigin
public class SchoolsController {
    private final SchoolService schoolService;
    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @GetMapping("getByStaffId")
    public DataResult<List<School>> getByStaffId(@RequestParam int staffId){
        return schoolService.getByStaffId(staffId);
    }
    @GetMapping("getByStaffIdOrderByGraduationYearDesc")
    public DataResult<List<School>> getByStaffIdOrderByGraduationYearDesc(@RequestParam int staffId){
        return schoolService.getByStaff_IdOrderByGraduationYearDesc(staffId);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody School school){
        return ResponseEntity.ok(schoolService.add(school));
    }
    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody School school){
        return ResponseEntity.ok(schoolService.update(school));
    }
    @PostMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestBody School school){
        return ResponseEntity.ok(schoolService.delete(school));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErrorDataResult<>(validationErrors, "Doğrulama hataları");
    }

}
