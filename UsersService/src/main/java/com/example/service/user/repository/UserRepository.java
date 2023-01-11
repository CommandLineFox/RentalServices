package com.example.service.user.repository;

import com.example.service.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsernameAndPassword(String username, String password);

    User findByUserId(int userId);
}
