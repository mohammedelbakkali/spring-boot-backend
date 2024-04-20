package com.example.demo.dto;

import com.example.demo.entities.Address;
import com.example.demo.entities.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.demo.entities.Address}
 */
@Value
@Getter
@Setter
@Builder
public class AddressDto implements Serializable {
    Long id;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
    String street;
    Integer houseNumber;
    Integer zipCpde;
    String city;
    String country;
    Long id_user;

    public static Address toEntity(AddressDto addressDto){
         return  Address
                 .builder()
                 .id(addressDto.getId())
                 .city(addressDto.getCity())
                 .country(addressDto.getCountry())
                 .street(addressDto.getStreet())
                 .zipCpde(addressDto.getZipCpde())
                 .houseNumber(addressDto.getHouseNumber())
                 .lastModifiedDate(addressDto.getLastModifiedDate())
                 .createdDate(addressDto.getCreatedDate())
                 .user(
                         User.builder().id(addressDto.getId_user()).build()
                 ).build();
    }

    public static AddressDto toDto(Address address){
        return AddressDto.builder().id(address.getId())
                .city(address.getCity())
                .country(address.getCountry())
                .street(address.getStreet())
                .zipCpde(address.getZipCpde())
                .houseNumber(address.getHouseNumber())
                .lastModifiedDate(address.getLastModifiedDate())
                .createdDate(address.getCreatedDate())
                .id_user(address.getUser().getId())
                .build();
    }

}