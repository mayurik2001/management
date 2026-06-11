package com.library.management.service;

import com.library.management.entity.BaseLookupEntity;

import java.util.List;

public interface BaseLookupService<T extends BaseLookupEntity> {

    T save(T entity);

    List<T> getAll();

    void delete(Long id);

    T getById(Long id);

    T update(Long id,T entity);
}
