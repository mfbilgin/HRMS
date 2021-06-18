package com.mfbilgin.HRMS.Entites.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForUserDto {
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String password;

}
