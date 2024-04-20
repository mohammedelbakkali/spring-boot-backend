package com.example.demo.dto;

import com.example.demo.entities.Phase;
import com.example.demo.entities.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.demo.entities.Phase}
 */
@Getter
@Setter
@Builder
public class PhaseDto implements Serializable {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
    String name;
    String description;
    Long id_product;


    public static PhaseDto toDto(Phase entity) {
        return PhaseDto.builder()
                .id(entity.getId())
                .createdDate(entity.getCreatedDate())
                .lastModifiedDate(entity.getLastModifiedDate())
                .name(entity.getName())
                .description(entity.getDescription())
                .id_product(entity.getProduct().getId())
                .build();
    }

    public static Phase toEntity(PhaseDto dto) {
        return Phase.builder()
                .id(dto.getId())
                .createdDate(dto.getCreatedDate())
                .lastModifiedDate(dto.getLastModifiedDate())
                .name(dto.getName())
                .description(dto.getDescription())
                .product(
                        Product.builder().id(dto.id_product).build()
                )
                .build();
    }

}