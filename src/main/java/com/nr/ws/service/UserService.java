package com.nr.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nr.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
    UserDto createUser(UserDto user);
}
