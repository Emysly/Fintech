package com.emysilva.fintech.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserCreateRequest {
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "^[+]*[(]?[0-9]{1,4}[)]?[-\\s/0-9]*$", message = "Phone number is invalid")
    private String phoneNumber;
    @NotEmpty(message = "Password is required")
    @Pattern(regexp = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+*!=]).*$",
            message = "Password should have at least 1 uppercase, 1 lowercase, 1 special character and of 8 characters or more")
    private String password;
    @NotEmpty(message = "Email address is required")
    @Email(regexp = "^\\S+@\\S+\\.\\S+$", message = "Email address is invalid")
    private String email;
    private String name;
    private String userName;

}
