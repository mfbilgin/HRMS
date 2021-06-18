package com.mfbilgin.HRMS.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Entites.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@Table(name="employers")
public class Employer extends User {

    @Column(name="company_name")
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name="web_address")
    @NotNull
    @NotBlank
    private String webAddress;

    @Column(name="phone_number")
    @NotNull
    @NotBlank
    private String phoneNumber;

    @Column(name="is_activated_by_system_staff")
    private boolean isActivatedBySystemStaff;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}