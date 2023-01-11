package com.example.service.user.repository;

import com.example.service.user.domain.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends JpaRepository<Rank,Long> {

}
