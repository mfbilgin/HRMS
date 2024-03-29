package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.EmployerService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Employer;
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
@RequestMapping("/api/employers/")
@CrossOrigin
public class EmployersController {
    private final EmployerService employerService;
    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("add")
    private ResponseEntity<?> add(@Valid @RequestBody Employer employer){
        return ResponseEntity.ok(employerService.add(employer));
    }

    @PostMapping("update")
    private ResponseEntity<?> update(@Valid @RequestBody Employer employer){
        return ResponseEntity.ok(employerService.addToUpdate(employer));
    }

    @GetMapping("setStatus")
    public Result setUpdateStatus(@RequestParam int employerId) {
        return this.employerService.setUpdateStatus(employerId);
    }

    @GetMapping("getAll")
    private DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("getById")
    private DataResult<Employer> getById(@RequestParam int id){
        return this.employerService.getById(id);
    }

    @GetMapping("getByIfHaveJobAdvertisement")
    private DataResult<List<Employer>> getByIfHaveJobAdvertisement(){
        return this.employerService.getByIfHaveJobAdvertisement();
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
