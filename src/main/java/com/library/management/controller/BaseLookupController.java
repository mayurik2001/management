package com.library.management.controller;

import com.library.management.DTO.NameRequest;
import com.library.management.entity.BaseLookupEntity;
import com.library.management.service.BaseLookupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseLookupController<T extends BaseLookupEntity> {

    private final BaseLookupService<T> service;

    protected BaseLookupController(BaseLookupService<T> service) {
        this.service = service;
    }

    protected abstract T createEntity();

    @GetMapping
    public List<T> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public T save(@RequestBody NameRequest request) {

        T entity = createEntity();

        entity.setName(request.getName());

        return service.save(entity);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable Long id, @RequestBody NameRequest request) {
        T entity = createEntity();
        entity.setName(request.getName());
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.ok("Author deleted successfully");
    }
}