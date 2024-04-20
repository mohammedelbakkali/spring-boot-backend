package com.example.demo.entities;

import com.example.demo.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter

public class Transaction extends AbstractEntity{


    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;



    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;



}
