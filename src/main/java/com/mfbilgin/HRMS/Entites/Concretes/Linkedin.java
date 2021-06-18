package com.mfbilgin.HRMS.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "linkedins")
public class Linkedin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "linkedin_id")
    private int id;

    @Column(name = "account_address")
    private String accountAddress;

    @ManyToOne()
    @JoinColumn(name = "id")
    private Employer employer;

}
