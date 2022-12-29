package com.nr.ws.repository;

import com.nr.ws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
  UserEntity findByEmail(String email);
}
