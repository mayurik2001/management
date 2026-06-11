package com.library.management.controller;

import com.library.management.entity.Author;
import com.library.management.service.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lms/authors")
public class AuthorController extends BaseLookupController<Author> {

    public AuthorController(AuthorService service) {
        super(service);
    }

    @Override
    protected Author createEntity() {

        return new Author();
    }

}
