package com.emysilva.fintech.repositories;

import com.emysilva.fintech.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhoneNumber(String phoneNumber);

    User findByEmail(String email);

    User findByUserName(String userName);
}
