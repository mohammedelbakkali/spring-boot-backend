package com.example.demo.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Table(name ="_table")
public class User extends AbstractEntity  {
    @NotNull  @NotEmpty  @NotBlank
    private String firstname;
    @NotNull  @NotEmpty  @NotBlank
    private String lastname;
    @NotNull @NotEmpty @NotBlank @Email
    private String email;
    @NotNull  @NotEmpty  @NotBlank
    private String password;

    private boolean active;

     @OneToMany(mappedBy = "user")
     private List<Transaction> transactionList;

     @ManyToOne
     @JoinColumn(name = "id_contact")
     private Contact contact;

     @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
     private Account account;

    @OneToOne
    private Address address;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;


    @OneToMany(mappedBy = "user")
    private List<Product> products;



    @OneToMany(mappedBy = "user")
    private List<MP> mps;


}
