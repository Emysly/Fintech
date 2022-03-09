package com.emysilva.fintech.service;

import com.emysilva.fintech.entities.Role;
import com.emysilva.fintech.entities.User;
import com.emysilva.fintech.http.ApiResponse;
import com.emysilva.fintech.http.UserCreateRequest;
import com.emysilva.fintech.http.UserLoginRequest;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    ApiResponse userCreate(UserCreateRequest userCreateRequest);

    ApiResponse userLogin(UserLoginRequest userLoginRequest);

    void saveUser(User user);

    void saveRole(Role role);

    void addRoleToUser(String phoneNumber, String roleName);

}
