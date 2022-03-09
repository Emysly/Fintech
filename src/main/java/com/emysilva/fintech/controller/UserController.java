package com.emysilva.fintech.controller;

import com.emysilva.fintech.http.ApiResponse;
import com.emysilva.fintech.http.UserCreateRequest;
import com.emysilva.fintech.http.UserLoginRequest;
import com.emysilva.fintech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ApiResponse userCreate(@Valid @RequestBody UserCreateRequest userCreateRequest) {

        return userService.userCreate(userCreateRequest);
    }

    @PostMapping("/login")
    public String userLogin(@Valid @RequestBody UserLoginRequest userLoginRequest) {

//        return userService.userLogin(userLoginRequest);

        return "Login successful!";
    }

}
