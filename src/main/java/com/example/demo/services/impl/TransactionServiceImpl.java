package com.example.demo.services.impl;

import com.example.demo.Repository.TransactionRepository;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Product;
import com.example.demo.entities.Transaction;
import com.example.demo.services.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Long save(TransactionDto dto) {

        Transaction tr = TransactionDto.toEntity(dto);
        return this.transactionRepository.save(tr).getId();
    }

    @Override
    public List<TransactionDto> findAll() {
        return this.transactionRepository
                .findAll()
                .stream().map(tr-> TransactionDto.toDto(tr))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto findById(Long id) {
        return this.transactionRepository
                .findById(id).map(tr->TransactionDto.toDto(tr))
                .orElseThrow(()->new EntityNotFoundException());
    }

    @Override
    public void delete(Long id) {
        // todo check before delete
        this.transactionRepository.deleteById(id);
    }


    @Override
    public List<TransactionDto> findAllByUserId(Long id) {
        return this.transactionRepository
                .findAllByUserId(id)
                .stream()
                .map(tr->TransactionDto.toDto(tr))
                .collect(Collectors.toList());
    }
}
