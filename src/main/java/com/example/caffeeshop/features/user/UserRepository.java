package com.example.caffeeshop.features.user;

import com.example.caffeeshop.doman.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByCodeUser(String codeUser);
    Boolean existsByCodeUser(String codeUser);
}
