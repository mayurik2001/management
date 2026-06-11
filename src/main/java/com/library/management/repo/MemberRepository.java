package com.library.management.repo;

import com.library.management.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    boolean existsByMobileNo(String mobileNo);

    long countByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}
