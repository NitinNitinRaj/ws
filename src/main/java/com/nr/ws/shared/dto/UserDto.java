package com.nr.ws.shared.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto implements Serializable {

  private static final long serialVersionUID = 6303520000477201063L;
  private long id;
  private String userId;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String encryptedPassword;
  private String emailVerificationToken;
  private Boolean emailVerificationStatus = false;
}
