package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter

public class Contact extends AbstractEntity{


    @OneToMany(mappedBy = "contact")
    private List<User> users;


}
