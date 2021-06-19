package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.LanguageService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.Language;
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
@RequestMapping("/api/languages/")
@CrossOrigin
public class LanguagesController {
    private final LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("getByStaffId")
    public DataResult<List<Language>> getByStaffId(@RequestParam int staffId){
        return languageService.getByStaffId(staffId);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Language language){
        return ResponseEntity.ok(languageService.add(language));
    }
    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody Language language){
        return ResponseEntity.ok(languageService.update(language));
    }
    @PostMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestBody Language language){
        return ResponseEntity.ok(languageService.delete(language));
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
