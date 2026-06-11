package com.library.management.repo;

import com.library.management.entity.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends BaseLookupRepository<Author> {
}
