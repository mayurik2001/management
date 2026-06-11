package com.library.management.controller;

import com.library.management.entity.ResourceStatus;
import com.library.management.service.ResourceStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/resource-statuses")
public class ResourceStatusController extends BaseLookupController<ResourceStatus>{

    public ResourceStatusController(ResourceStatusService service){

        super(service);
    }

    protected ResourceStatus createEntity(){

        return new ResourceStatus();
    }
}
