package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.JobAdvertisementService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
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
    @GetMapping("approveJobAdvertisement")
    public Result approveJobAdvertisement(@RequestParam int jobAdvertisementId) {
        return jobAdvertisementService.approveJobAdvertisement(jobAdvertisementId);
    }
    @GetMapping("getById")
    public DataResult<JobAdvertisement> getById(@RequestParam int id){
        return jobAdvertisementService.getById(id);
    }
    @GetMapping("getByIdAndStatusIsTrue")
    public DataResult<JobAdvertisement> getByIdAndStatusIsTrue(@RequestParam int id){
        return jobAdvertisementService.getByIdAndStatusIsTrue(id);
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
    @GetMapping("getByStatusIsTrueAndApprovedByAdminIsFalse")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsFalse(){
        return jobAdvertisementService.getByStatusIsTrueAndApprovedByAdminIsFalse();
    }

    @GetMapping("getByStatusIsTrueAndOrderByApplicationDeadlineDesc")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineDesc(){
        return jobAdvertisementService.getByStatusIsTrueAndOrderByApplicationDeadlineDesc();
    }
    @GetMapping("getByStatusIsTrueAndOrderByApplicationDeadlineAsc")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndOrderByApplicationDeadlineAsc(@RequestParam int pageNo,@RequestParam int pageSize){
        return jobAdvertisementService.getByStatusIsTrueAndOrderByApplicationDeadlineAsc(pageNo,pageSize);
    }
    @GetMapping("/getPageCount")
    public DataResult<Integer> getPageCount(@RequestParam int pageSize){
        return this.jobAdvertisementService.getPageCount(pageSize);
    }
    @GetMapping("getByStatusIsTrueAndEmployer_Id")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndEmployer_Id(@RequestParam int id){
        return jobAdvertisementService.getByStatusIsTrueAndEmployer_Id(id);
    }
    @GetMapping("getByStatusIsTrueAndCity_Id")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndCity_Id(@RequestParam int cityId){
        return jobAdvertisementService.getByStatusIsTrueAndCity_Id(cityId);
    }
    @GetMapping("getByStatusIsFalseAndEmployer_Id")
    public DataResult<List<JobAdvertisement>> getByStatusIsFalseAndEmployer_Id(@RequestParam int employerId){
        return jobAdvertisementService.getByStatusIsFalseAndEmployer_Id(employerId);
    }
    @GetMapping("getByStatusIsFalse")
    public DataResult<List<JobAdvertisement>> getByStatusIsFalse(){
        return jobAdvertisementService.getByStatusIsFalse();
    }
    @GetMapping("getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_IdAndWorkTime_Id")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_IdAndWorkTime_Id(@RequestParam int cityId,@RequestParam int workTimeId ){
        return jobAdvertisementService.getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_IdAndWorkTime_Id(cityId,workTimeId);
    }
    @GetMapping("getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_Id")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_Id(@RequestParam int cityId){
        return jobAdvertisementService.getByStatusIsTrueAndApprovedByAdminIsTrueAndCity_Id(cityId);
    }
    @GetMapping("getByStatusIsTrueAndApprovedByAdminIsTrueAndWorkTime_Id")
    public DataResult<List<JobAdvertisement>> getByStatusIsTrueAndApprovedByAdminIsTrueAndWorkTime_Id(@RequestParam int workTimeId){
        return jobAdvertisementService.getByStatusIsTrueAndApprovedByAdminIsTrueAndWorkTime_Id(workTimeId);
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
