package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter

public class Phase extends  AbstractEntity{

    private String name;
    private String description;


    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
}
