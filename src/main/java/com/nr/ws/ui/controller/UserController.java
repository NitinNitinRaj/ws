package com.nr.ws.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(
    UserController.class
  );

  @GetMapping
  public String getUser() {
    LOGGER.info("getUser() was called");
    return "get user was called";
  }

  @PostMapping
  public String postUser() {
    LOGGER.info("postUser() was called");
    return "postUser was called";
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
