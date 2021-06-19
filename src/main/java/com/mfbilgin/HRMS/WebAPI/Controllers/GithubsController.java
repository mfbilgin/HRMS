package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.GithubService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.CoverLetter;
import com.mfbilgin.HRMS.Entites.Concretes.Github;
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
@RequestMapping("/api/githubs/")
@CrossOrigin
public class GithubsController {
    private final GithubService githubService;
    @Autowired
    public GithubsController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("getByStaffId")
    public DataResult<Github> getByStaffId(@RequestParam int staffId){
        return githubService.getByStaffId(staffId);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Github github){
        return ResponseEntity.ok(githubService.add(github));
    }
    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody Github github){
        return ResponseEntity.ok(githubService.update(github));
    }
    @PostMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestBody Github github){
        return ResponseEntity.ok(githubService.delete(github));
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
