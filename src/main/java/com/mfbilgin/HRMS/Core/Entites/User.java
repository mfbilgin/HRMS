package com.mfbilgin.HRMS.Core.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull
    private int id;

    @Column(name="email")
    @NotNull
    @NotBlank
    @Email
    private String email;

    @Column(name="password")
    @NotNull
    @NotBlank
    private String password;

    @Column(name="is_verified_by_email")
    private boolean isVerifiedByEmail;
}
