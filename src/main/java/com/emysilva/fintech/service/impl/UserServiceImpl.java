package com.emysilva.fintech.service.impl;

import com.emysilva.fintech.entities.Role;
import com.emysilva.fintech.entities.User;
import com.emysilva.fintech.exception.UserExistsException;
import com.emysilva.fintech.filter.CustomAuthenticationFilter;
import com.emysilva.fintech.http.ApiResponse;
import com.emysilva.fintech.http.UserCreateRequest;
import com.emysilva.fintech.http.UserCreateResponse;
import com.emysilva.fintech.http.UserLoginRequest;
import com.emysilva.fintech.repositories.RoleRepository;
import com.emysilva.fintech.repositories.UserRepository;
import com.emysilva.fintech.service.UserService;
import com.emysilva.fintech.service.util.UserHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserHelper userHelper;
    private final AuthenticationManager authenticationManager;

    @Override
    public ApiResponse userCreate(UserCreateRequest userCreateRequest) {
        if (userHelper.phoneNumberExist(userCreateRequest.getPhoneNumber())) {
            log.error("Phone number already exists: {}", userCreateRequest.getPhoneNumber());
            throw new UserExistsException("Phone number already exists");
        }

        if (userHelper.emailExist(userCreateRequest.getEmail())) {
            log.error("Email address already exists: {}", userCreateRequest.getEmail());
            throw new UserExistsException("Email address already exists");
        }

        if (userCreateRequest.getUserName() != null && userHelper.userNameExist(userCreateRequest.getUserName())) {
            log.error("Username already exists: {}", userCreateRequest.getUserName());
            throw new UserExistsException("Username already exists");
        }

        User user = User.builder().userName(userCreateRequest.getUserName())
                .email(userCreateRequest.getEmail())
                .name(userCreateRequest.getName())
                .phoneNumber(userCreateRequest.getPhoneNumber())
                .password(passwordEncoder.encode(userCreateRequest.getPassword())).build();

        userRepository.save(user);

        UserCreateResponse userCreateResponse = UserCreateResponse.builder().userName(user.getUserName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .name(user.getName()).build();

        return ApiResponse.builder().success(true).status(201).message("User created successfully!").data(userCreateResponse).build();
    }

    @Override
    public ApiResponse userLogin(UserLoginRequest userLoginRequest) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }


    @Override
    public void addRoleToUser(String phoneNumber, String roleName) {
        User foundUser = userRepository.findByPhoneNumber(phoneNumber);
        Role role = roleRepository.findByName(roleName);

        foundUser.getRoles().add(role);
    }
}
