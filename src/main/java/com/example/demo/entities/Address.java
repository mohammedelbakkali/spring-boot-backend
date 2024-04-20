package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Address extends AbstractEntity{



    private String street;
    private Integer houseNumber;
    private Integer zipCpde;
    private String city;
    private String country;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
