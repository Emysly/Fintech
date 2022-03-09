package com.emysilva.fintech.service.util;

import com.emysilva.fintech.repositories.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@Component
public class UserHelper {

    private final UserRepository userRepository;

    public boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public boolean phoneNumberExist(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber) != null;
    }

    public boolean userNameExist(String userName) {
        return userRepository.findByUserName(userName) != null;
    }
}
