package com.mfbilgin.HRMS.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "githubs")
public class Github {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "github_id")
    private int id;

    @Column(name = "account_address")
    private String accountAddress;

    @ManyToOne()
    @JoinColumn(name = "staff_id")
    private Staff staff;

}
