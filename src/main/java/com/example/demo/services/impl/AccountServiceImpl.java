package com.example.demo.services.impl;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Account;
import com.example.demo.services.AccountService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Long save(AccountDto dto) {
        Account account =AccountDto.toEntity(dto);
        boolean userHasAlreadyAnAccount = this.accountRepository.findById(account.getUser().getId()).isPresent();
        if(userHasAlreadyAnAccount){
            throw new RuntimeException("the selected user has already an active account");
        }
        account.setCode_account(this.generateRandomCode());
        return this.accountRepository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {

        return this.accountRepository
                .findAll()
                .stream()
                .map(a-> AccountDto.toDto(a))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Long id) {
      return   this.accountRepository
              .findById(id)
              .map(a->AccountDto.toDto(a))
              .orElseThrow(()->new EntityNotFoundException());


    }

    @Override
    public void delete(Long id) {
      // todo check delete account
        this.accountRepository.deleteById(id);
    }

    private String generateRandomCode(){
         UUID uuid = UUID.randomUUID();
         return uuid.toString();
    }
}
