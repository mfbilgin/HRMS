package com.mfbilgin.HRMS.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Entites.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
@Table(name = "system_staffs")
public class SystemStaff extends User {
    @Column(name = "first_name")
    @NotNull
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @NotBlank
    private String lastName;

}
