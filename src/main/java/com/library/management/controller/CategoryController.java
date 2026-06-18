package com.library.management.controller;

import com.library.management.entity.Category;
import com.library.management.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/categories")
public class CategoryController extends BaseLookupController<Category>{

    public CategoryController(CategoryService service){
        super(service);

    }

    @Override
    protected Category createEntity(){
        return new Category();
    }
}
