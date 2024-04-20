package com.example.demo.services.impl;

import com.example.demo.Repository.AddressRepository;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AddressDto;
import com.example.demo.entities.Account;
import com.example.demo.entities.Address;
import com.example.demo.services.AddressService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Long save(AddressDto dto) {
        Address ad = AddressDto.toEntity(dto);
        return this.addressRepository.save(ad).getId();
    }

    @Override
    public List<AddressDto> findAll() {
        return this.addressRepository
                .findAll()
                .stream()
                .map(a-> AddressDto.toDto(a))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(Long id) {
        return   this.addressRepository
                .findById(id)
                .map(a->AddressDto.toDto(a))
                .orElseThrow(()->new EntityNotFoundException());

    }

    @Override
    public void delete(Long id) {
        /* todo check delete account */
        this.addressRepository.deleteById(id);
    }
}
