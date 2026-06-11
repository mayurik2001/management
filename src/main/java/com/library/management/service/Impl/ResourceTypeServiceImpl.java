package com.library.management.service.Impl;

import com.library.management.entity.ResourceType;
import com.library.management.repo.ResourceTypeRepository;
import com.library.management.service.ResourceTypeService;
import org.springframework.stereotype.Service;


@Service
public class ResourceTypeServiceImpl extends BaseLookupServiceImpl<ResourceType>
           implements ResourceTypeService {

    public ResourceTypeServiceImpl(ResourceTypeRepository repository){

        super(repository);
    }
}
