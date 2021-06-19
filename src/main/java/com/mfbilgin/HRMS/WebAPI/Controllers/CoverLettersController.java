package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.CoverLetterService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.CoverLetter;
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
@RequestMapping("/api/coverLetters/")
@CrossOrigin
public class CoverLettersController {
    private final CoverLetterService coverLetterService;
    @Autowired
    public CoverLettersController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @GetMapping("getByStaffId")
    public DataResult<CoverLetter> getByStaffId(@RequestParam int staffId){
        return coverLetterService.getByStaffId(staffId);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody CoverLetter coverLetter){
        return ResponseEntity.ok(coverLetterService.add(coverLetter));
    }
    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody CoverLetter coverLetter){
        return ResponseEntity.ok(coverLetterService.update(coverLetter));
    }
    @PostMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestBody CoverLetter coverLetter){
        return ResponseEntity.ok(coverLetterService.delete(coverLetter));
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

