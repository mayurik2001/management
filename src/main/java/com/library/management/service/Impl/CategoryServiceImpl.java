package com.library.management.service.Impl;

import com.library.management.entity.Category;
import com.library.management.repo.CategoryRepository;
import com.library.management.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseLookupServiceImpl<Category> implements CategoryService  {


    public CategoryServiceImpl(CategoryRepository repository){
        super(repository);
    }
}
