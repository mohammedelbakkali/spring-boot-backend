package com.example.demo.services.impl;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.services.AccountService;
import com.example.demo.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    public UserRepository userRepository;
    public AccountService accountService;
    @Autowired
    public AccountRepository accountRepository;


    public UserServiceImpl(UserRepository userRepository,AccountService accountService) {
        this.userRepository = userRepository;
        this.accountService=accountService;

    }


    @Override
    public Long save(UserDto dto) {
        User user = UserDto.toEntity(dto);
        return this.userRepository.save(user).getId();

    }

    @Override
    public List<UserDto> findAll() {

        return this.userRepository
                .findAll()
                .stream().map(UserDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return this.userRepository.findById(id).map(UserDto::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
       // todo check before delete
        this.userRepository.deleteById(id);
    }

    @Override
    public Long validateAccount(Long id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No User was found for user account validation"));
        user.setActive(true);
        Account account = new Account();
        account.setUser(user);
        user.setAccount(account);
        userRepository.save(user);
        return user.getId();

    }


    @Override
    public Long invalidateAccount(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("no User was found for user account validation"));
        user.setActive(false);
        Long id_account = user.getAccount().getId();
        user.setAccount(null);
        this.userRepository.save(user);
        this.accountService.delete(id_account);
        return user.getId();
    }


}
