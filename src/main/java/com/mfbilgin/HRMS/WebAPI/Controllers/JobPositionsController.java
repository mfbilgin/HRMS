package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.JobPositionService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.JobPosition;
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
@RequestMapping("/api/jobPositions/")
@CrossOrigin
public class JobPositionsController {
    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;

    }
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobPosition jobPosition){
        return ResponseEntity.ok(this.jobPositionService.add(jobPosition));
    }
    @GetMapping("getall")
    public DataResult<List<JobPosition>> getAll(){
        return jobPositionService.getAll();
    }

    @GetMapping("getById")
    public DataResult<JobPosition> getById(@RequestParam int id){
        return jobPositionService.getById(id);
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
