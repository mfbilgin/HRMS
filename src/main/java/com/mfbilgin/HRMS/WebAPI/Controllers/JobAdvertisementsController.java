package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.JobAdvertisementService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.JobAdvertisement;
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
@RequestMapping("/api/jobAdvertisement/")
@CrossOrigin
public class JobAdvertisementsController {
    private final JobAdvertisementService jobAdvertisementService;
    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
    }
    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.jobAdvertisementService.update(jobAdvertisement));
    }
    @PostMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.jobAdvertisementService.delete(jobAdvertisement));
    }
    @PostMapping("setStatus")
    public ResponseEntity<?> setStatus(@RequestParam int id){
        return ResponseEntity.ok(this.jobAdvertisementService.setStatus(id));
    }

    @GetMapping("getByStatusIsTrue")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrue(){
        return jobAdvertisementService.getByStatusIsTrue();
    }
    @GetMapping("getByStatusIsTrueAndOrderByReleaseDateDesc")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByReleaseDateDesc(){
        return jobAdvertisementService.getByStatusIsTrueAndOrderByReleaseDateDesc();
    }
    @GetMapping("getByStatusIsTrueAndOrderByReleaseDateAsc")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByReleaseDateAsc(){
        return jobAdvertisementService.getByStatusIsTrueAndOrderByReleaseDateAsc();
    }
    @GetMapping("getByStatusIsTrueAndOrderByApplicationDeadlineDesc")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineDesc(){
        return jobAdvertisementService.getByStatusIsTrueAndOrderByApplicationDeadlineDesc();
    }
    @GetMapping("getByStatusIsTrueAndOrderByApplicationDeadlineAsc")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineAsc(){
        return jobAdvertisementService.getByStatusIsTrueAndOrderByApplicationDeadlineAsc();
    }
    @GetMapping("getByStatusIsTrueAndEmployer_Id")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndEmployer_Id(@RequestParam int id){
        return jobAdvertisementService.getByStatusIsTrueAndEmployer_Id(id);
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
