package com.mfbilgin.HRMS.Entites.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForEmployerDto {
    @NotBlank
    @NotNull
    private String companyName;

    @NotBlank
    @NotNull
    private String website;

    @NotBlank
    @NotNull
    private String phoneNumber;

    @NotBlank
    @NotNull
    @Email
    private String email;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    private String passwordConfirm;
}
