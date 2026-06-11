package com.library.management.repo;

import com.library.management.entity.BookAssign;
import com.library.management.enums.BookAssignStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BookAssignRepository extends JpaRepository<BookAssign,Long> {
    boolean existsByMemberIdAndResourceIdAndStatus(
            Long memberId,
            Long resourceId,
            BookAssignStatus status);

    long countByAssignedAtBetween(LocalDateTime start, LocalDateTime end);
}
