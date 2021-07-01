package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.WorkService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.Work;
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
@RequestMapping("/api/works/")
@CrossOrigin
public class WorksController {
    private final WorkService workService;
    @Autowired
    public WorksController(WorkService workService) {
        this.workService = workService;
    }
    @GetMapping("getByStaffId")
    public DataResult<List<Work>> getByStaffId(@RequestParam int staffId){
        return workService.getByStaffId(staffId);
    }
    @GetMapping("getByStaffIdOrderByGraduationYearDesc")
    public DataResult<List<Work>> getByStaffIdOrderByGraduationYearDesc(@RequestParam int staffId){
        return workService.getByStaff_IdOrderByLeaveYearDesc(staffId);
    }
    @GetMapping("getById")
    public DataResult<Work> getById(@RequestParam int id){
        return workService.getById(id);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Work work){
        return ResponseEntity.ok(workService.add(work));
    }
    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody Work work){
        return ResponseEntity.ok(workService.update(work));
    }
    @GetMapping("delete")
    public ResponseEntity<?> delete(@RequestParam int workId){
        return ResponseEntity.ok(workService.delete(workId));
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
