package com.mfbilgin.HRMS.Entites.Concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name = "staff_id")
    private Staff staff;

}
