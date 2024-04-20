package com.example.demo.Repository;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
   List<Transaction> findAllByUserId(Long id);
}
