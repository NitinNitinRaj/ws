package com.nr.ws.service.impl;

import com.nr.ws.io.entity.UserEntity;
import com.nr.ws.repository.UserRepository;
import com.nr.ws.service.UserService;
import com.nr.ws.shared.Utils;
import com.nr.ws.shared.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final Utils utils;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public UserDto createUser(UserDto user) {
    if (
      userRepository.findByEmail(user.getEmail()) != null
    ) throw new RuntimeException("Record Already exists");

    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(user, userEntity);
    userEntity.setUserId(utils.generateUserId(30));
    userEntity.setEncryptedPassword(
      bCryptPasswordEncoder.encode(user.getPassword())
    );
    UserEntity userEntityDb = userRepository.save(userEntity);
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(userEntityDb, userDto);
    return userDto;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }
}
