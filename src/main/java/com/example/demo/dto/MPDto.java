package com.example.demo.dto;

import com.example.demo.entities.MP;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.demo.entities.MP}
 */
@Value
@Getter
@Setter
@Builder
public class MPDto implements Serializable {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
    String name;
    Long id_product;
    Long id_user;

    public static MPDto toDto(MP entity) {
        return MPDto.builder()
                .id(entity.getId())
                .createdDate(entity.getCreatedDate())
                .id_product(entity.getProduct().getId())
                .id_user(entity.getUser().getId())
                .lastModifiedDate(entity.getLastModifiedDate())
                .name(entity.getName())
                .build();
    }

    public static MP toEntity(MPDto dto) {
        return MP.builder()
                .id(dto.getId())
                .createdDate(dto.getCreatedDate())
                .lastModifiedDate(dto.getLastModifiedDate())
                .name(dto.getName())
                .user(
                        User.builder().id(dto.getId_user()).build()
                ).product(
                        Product.builder().id(dto.getId_product()).build()
                )
                .build();
    }

}