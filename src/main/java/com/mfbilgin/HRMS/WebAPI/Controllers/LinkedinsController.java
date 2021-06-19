package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.LinkedinService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.Linkedin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin
public class LinkedinsController {
    private final LinkedinService linkedinService;
    @Autowired
    public LinkedinsController(LinkedinService linkedinService) {
        this.linkedinService = linkedinService;
    }
    @GetMapping("getByStaffId")
    public DataResult<Linkedin> getByStaffId(@RequestParam int staffId){
        return linkedinService.getByStaffId(staffId);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Linkedin github){
        return ResponseEntity.ok(linkedinService.add(github));
    }
    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody Linkedin github){
        return ResponseEntity.ok(linkedinService.update(github));
    }
    @PostMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestBody Linkedin github){
        return ResponseEntity.ok(linkedinService.delete(github));
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
