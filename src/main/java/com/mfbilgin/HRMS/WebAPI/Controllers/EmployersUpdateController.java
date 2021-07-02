package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.EmployerUpdateService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.EmployerUpdate;
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
@RequestMapping("/api/employerUpdate/")
@CrossOrigin
public class EmployersUpdateController {
    private final EmployerUpdateService employerUpdateService;
    @Autowired
    public EmployersUpdateController(EmployerUpdateService employerUpdateService) {
        this.employerUpdateService = employerUpdateService;
    }

    @GetMapping("getAll")
    public DataResult<List<EmployerUpdate>> getAll(){
        return employerUpdateService.getAll();
    }

    @GetMapping("getByEmployerId")
    public DataResult<EmployerUpdate> getByEmployerId(@RequestParam int employerId){
        return employerUpdateService.getByEmployer_Id(employerId);
    }
    @GetMapping("delete")
    public Result delete(@RequestParam int id){
        return employerUpdateService.delete(id);
    }
    //
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
