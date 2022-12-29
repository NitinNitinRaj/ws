package com.nr.ws.ui.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.nr.ws.service.UserService;
import com.nr.ws.shared.dto.UserDto;
import com.nr.ws.ui.model.request.UserDetailsRequestModel;
import com.nr.ws.ui.model.response.UserRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService userService;

  private static final Logger LOGGER = LoggerFactory.getLogger(
    UserController.class
  );

  @GetMapping
  public String getUser() {
    LOGGER.info("getUser() was called");
    return "get user was called";
  }

  @PostMapping
  public ResponseEntity<UserRest> postUser(
    @RequestBody UserDetailsRequestModel userDetails
  ) {
    LOGGER.info("postUser() was called");

    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(userDetails, userDto);

    UserDto createdUSer = userService.createUser(userDto);
    UserRest returnValue = new UserRest();

    BeanUtils.copyProperties(createdUSer, returnValue);

    return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
  }

  @PutMapping
  public String putUser() {
    LOGGER.info("putUser() was called");
    return "putUser was called";
  }

  @DeleteMapping
  public String deleteUser() {
    LOGGER.info("deleteUser() was called");
    return "deleteUser was called";
  }
}
