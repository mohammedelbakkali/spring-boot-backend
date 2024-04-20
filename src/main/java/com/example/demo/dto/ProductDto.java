package com.example.demo.dto;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.demo.entities.Product}
 */
@Value
@Getter
@Setter
@Builder
public class ProductDto implements Serializable {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
    String name;
    Integer code;
    Long id_user;

    public static ProductDto toDto(Product entity) {
        return ProductDto.builder()
                .id(entity.getId())
                .createdDate(entity.getCreatedDate())
                .lastModifiedDate(entity.getLastModifiedDate())
                .name(entity.getName())
                .code(entity.getCode())
                .id_user(entity.getUser().getId())
                .build();
    }


    public static Product toEntity(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .createdDate(dto.getCreatedDate())
                .lastModifiedDate(dto.getLastModifiedDate())
                .name(dto.getName())
                .code(dto.getCode())
                .user(
                        User.builder().id(dto.getId_user()).build()
                )
                .build();
    }
}