package com.crazyemperor.homework35loggingtransactional.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Table(name = "Payments")
public class Payment {

    @Id
    @Column(name = "PaymentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Basic(optional = false)
    @Column(name = "UserID")
    private User userID;

    @Basic(optional = false)
    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    private LocalDate date;
}
