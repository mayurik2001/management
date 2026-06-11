package com.library.management.service.Impl;

import com.library.management.entity.Author;
import com.library.management.repo.AuthorRepository;
import com.library.management.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends BaseLookupServiceImpl<Author>
        implements AuthorService {

    public AuthorServiceImpl(AuthorRepository repository){
        super(repository);
    }
}
