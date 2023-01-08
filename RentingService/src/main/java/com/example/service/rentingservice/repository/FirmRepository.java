package com.example.service.rentingservice.repository;

import com.example.service.rentingservice.domain.Firm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmRepository extends JpaRepository<Firm, Long> {
}
