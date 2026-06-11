package com.library.management.repo;

import com.library.management.entity.BaseLookupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseLookupRepository<T extends BaseLookupEntity> extends JpaRepository<T,Long> {
    boolean existsByNameIgnoreCase(String name);

}
