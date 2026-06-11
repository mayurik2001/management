package com.library.management.service.Impl;

import com.library.management.entity.BaseLookupEntity;
import com.library.management.repo.BaseLookupRepository;
import com.library.management.service.BaseLookupService;

import java.util.List;

public abstract class BaseLookupServiceImpl<T extends BaseLookupEntity> implements BaseLookupService<T> {

    private final BaseLookupRepository<T> repository;

    protected BaseLookupServiceImpl(BaseLookupRepository<T> repository){
        this.repository=repository;
    }

    @Override
     public  T save (T entity) {

        String name = entity.getName().trim();

        if (name.isEmpty()) {
            throw new RuntimeException("Name cannot be empty");
        }
        if(repository.existsByNameIgnoreCase(name)){
            throw new RuntimeException(name+" already exist");
        }
      entity.setName(name);
        return repository.save(entity);
    }

    @Override
    public List<T> getAll(){

        return repository.findAll();
    }

    @Override
    public T getById(Long id){
        return repository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Record not found"));
    }

    @Override
    public T update(Long id,T entity){
        T existingEntity=repository.findById(id)
                .orElseThrow(()->
                  new RuntimeException("Record not found"));
        String name=entity.getName().trim();
        if (name.isEmpty()){
            throw new RuntimeException("Name can't be empty");
        }
        existingEntity.setName(name);
        return repository.save(existingEntity);
    }

    @Override
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Record not found");
        }

        repository.deleteById(id);
    }
}

