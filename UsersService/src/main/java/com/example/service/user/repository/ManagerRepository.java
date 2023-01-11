package com.example.service.user.repository;

import com.example.service.user.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findManagerByUsernameAndPassword(String username, String password);

    Manager findByManagerId(int managerId);
}
