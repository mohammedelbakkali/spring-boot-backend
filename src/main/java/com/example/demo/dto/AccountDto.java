package com.example.demo.dto;

import com.example.demo.entities.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Account}
 */
@Value
@Getter
@Setter
@Builder
public class AccountDto implements Serializable {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
    String code_account;
    UserDto userDto;
    public static Account toEntity(AccountDto accountDto){
        return Account
                .builder()
                .id(accountDto.getId())
                .code_account(accountDto.getCode_account())
                .user(UserDto.toEntity(accountDto.getUserDto()))
                .lastModifiedDate(accountDto.getLastModifiedDate()).build();
    }

    public static AccountDto toDto(Account account){
        return AccountDto.builder().id(account.getId())
                .code_account(account.getCode_account())
                .userDto(UserDto.toDto(account.getUser()))
                .lastModifiedDate(account.getLastModifiedDate()).build();
    }
    
}