package com.nr.ws.io.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
public class UserEntity implements Serializable {

  private static final long serialVersionUID = 1821671426882989656L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "UserId cannot be blank")
  private String userId;

  @NotBlank(message = "FirstName cannot be blank")
  @Column(length = 50)
  private String firstName;

  @NotBlank(message = "LastName cannot be blank")
  @Column(length = 50)
  private String lastName;

  @NotBlank(message = "Email cannot be blank")
  @Column(length = 120, unique = true)
  private String email;

  private String encryptedPassword;

  private String emailVerificationToken;

  private Boolean emailVerificationStatus = false;
}
