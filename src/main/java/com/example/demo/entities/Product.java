package com.example.demo.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter

public class Product extends  AbstractEntity{
    @NotNull
    @NotEmpty
    @NotBlank(message = "le name ne doit pas etre null !")
    @Size(min = 4,max = 500)
    private String name;
    @Max(value = 1000000000)
    @Min(value = 1)
    private Double price;
    private Integer code;


    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


    @OneToMany(mappedBy = "product")
    private List<MP> mps;

    @OneToMany(mappedBy = "product")
    private List<Phase> phases;

}
