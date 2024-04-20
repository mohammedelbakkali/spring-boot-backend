package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Account extends AbstractEntity{
    private String code_account;
    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
}
