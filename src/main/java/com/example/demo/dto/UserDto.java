package com.example.demo.dto;

import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.demo.entities.User}
 */
@Value
@Getter
@Setter
@Builder
public class UserDto implements Serializable {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
    String firstname;
    String lastname;
    String email;
    String password;
    boolean active;
    Long id_account;


    public static User toEntity(UserDto user){
        return User
                .builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .active(user.isActive())
                .password(user.getPassword())
                .account(
                        Account.builder().id(user.getId_account()).build()
                )
                .createdDate(user.getCreatedDate())
                .lastModifiedDate(user.getLastModifiedDate())
                .build();
    }

    public static UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .active(user.isActive())
                .email(user.getEmail())
                .id_account(user.getAccount()!=null?user.getAccount().getId():null)
                .password(user.getPassword())
                .createdDate(user.getCreatedDate())
                .lastModifiedDate(user.getLastModifiedDate())
                .build();
    }

}