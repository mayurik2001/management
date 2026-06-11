package com.library.management.service.Impl;

import com.library.management.entity.ResourceStatus;
import com.library.management.repo.ResourceStatusRepository;
import com.library.management.service.ResourceStatusService;
import org.springframework.stereotype.Service;


@Service
public class ResourceStatusServiceImpl extends BaseLookupServiceImpl<ResourceStatus>
         implements ResourceStatusService {

    public ResourceStatusServiceImpl(ResourceStatusRepository repository){
        super(repository);
    }
}

