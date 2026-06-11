package com.library.management.controller;

import com.library.management.entity.ResourceType;
import com.library.management.service.ResourceTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/resource-types")
public class ResourceTypeController extends  BaseLookupController<ResourceType> {

    public ResourceTypeController(ResourceTypeService service){

        super(service);
    }

    @Override
    protected ResourceType createEntity(){

        return new ResourceType();
    }
}
