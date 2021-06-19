package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.AuthService;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Dto.LoginForUserDto;
import com.mfbilgin.HRMS.Entites.Dto.RegisterForEmployerDto;
import com.mfbilgin.HRMS.Entites.Dto.RegisterForStaffDto;
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
@RequestMapping("/api/auth/")
@CrossOrigin
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("registerforemployer")
    public Result registerForEmployer(@Valid @RequestBody RegisterForEmployerDto registerForEmployerDto) {
        return authService.registerForEmployer(registerForEmployerDto);
    }

    @PostMapping("registerforcandidate")
    public ResponseEntity<?> registerForCandidate(@Valid @RequestBody RegisterForStaffDto registerForStaffDto) {
        return ResponseEntity.ok(authService.registerForStaff(registerForStaffDto));
    }
    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginForUserDto loginForUserDto){
        return ResponseEntity.ok(authService.login(loginForUserDto));
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

