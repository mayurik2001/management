package com.library.management.repo;

import com.library.management.entity.MemberRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRestrictionRepository extends JpaRepository<MemberRestriction,Long> {
}
