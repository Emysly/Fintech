package com.emysilva.fintech.service.impl;

import com.emysilva.fintech.entities.User;
import com.emysilva.fintech.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository.findByPhoneNumber(username);

        if (foundUser == null) {
            throw new UsernameNotFoundException("User with " + username + " not found");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        foundUser.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        System.out.println(foundUser);

        return new org.springframework.security.core.userdetails.User(foundUser.getPhoneNumber(), foundUser.getPassword(), authorities);

    }

}
