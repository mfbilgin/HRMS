package com.mfbilgin.HRMS.Entites.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cover_letters")
public class CoverLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cover_letter_id")
    private int id;

    @Column(name = "content")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "id")
    private Employer employer;
}
