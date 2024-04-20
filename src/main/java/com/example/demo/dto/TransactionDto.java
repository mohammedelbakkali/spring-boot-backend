package com.example.demo.dto;

import com.example.demo.entities.Transaction;
import com.example.demo.entities.User;
import com.example.demo.enums.TransactionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.demo.entities.Transaction}
 */
@Value
@Getter
@Setter
@Builder
public class TransactionDto implements Serializable {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
    BigDecimal amount;
    TransactionType transactionType;
    private Long id_user;

    public static TransactionDto toDto(Transaction entity) {
        return TransactionDto.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .transactionType(entity.getTransactionType())
                .id_user(entity.getUser().getId())
                .build();
    }

    public static Transaction toEntity(TransactionDto dto) {
        return Transaction.builder()
                .id(dto.getId())
                .amount(dto.getAmount())
                .transactionType(dto.getTransactionType())
                .user(
                        User.builder().id(dto.getId_user()).build()
                )
                .build();
    }



}