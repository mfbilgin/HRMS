package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.SkillService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Entites.Concretes.Skill;
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
@RequestMapping("/api/skills/")
@CrossOrigin
public class SkillsController{
    private final SkillService skillService;
    @Autowired
    public SkillsController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("getByStaffId")
    public DataResult<List<Skill>> getByStaffId(@RequestParam int staffId){
        return skillService.getByStaffId(staffId);
    }
    @GetMapping("getById")
    public DataResult<Skill> getById(@RequestParam int id){
        return skillService.getById(id);
    }
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Skill skill){
        return ResponseEntity.ok(skillService.add(skill));
    }
    @PostMapping("update")
    public ResponseEntity<?> update(@Valid @RequestBody Skill skill){
        return ResponseEntity.ok(skillService.update(skill));
    }
    @GetMapping("delete")
    public ResponseEntity<?> delete(@RequestParam int skillId){
        return ResponseEntity.ok(skillService.delete(skillId));
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
