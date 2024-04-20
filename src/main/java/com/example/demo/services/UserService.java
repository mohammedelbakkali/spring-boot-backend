package com.example.demo.services;

import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.User;

public interface UserService extends AbstractService<UserDto>{
    Long validateAccount(Long id);
    Long invalidateAccount(Long id);

}
