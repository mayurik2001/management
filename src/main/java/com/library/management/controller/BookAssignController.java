package com.library.management.controller;

import com.library.management.DTO.BookAssignRequest;
import com.library.management.DTO.BookAssignResponse;
import com.library.management.service.BookAssignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lms/book-assgin")
public class BookAssignController {

    private final BookAssignService service;

    public BookAssignController(
            BookAssignService service) {
        this.service = service;
    }

    @PostMapping
    public BookAssignResponse assignBook(
            @RequestBody BookAssignRequest request) {

        return service.assignBook(request);
    }

    @GetMapping
    public List<BookAssignResponse> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public BookAssignResponse getById(
            @PathVariable Long id) {

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public BookAssignResponse update(
            @PathVariable Long id,
            @RequestBody BookAssignRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id) {

        return service.delete(id);
    }

    @PutMapping("/{id}/return")
    public BookAssignResponse returnBook(
            @PathVariable Long id) {

        return service.returnBook(id);
    }
}