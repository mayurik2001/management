package com.library.management.controller;

import com.library.management.entity.Publisher;
import com.library.management.service.PublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/publishers")
public class PublisherController extends BaseLookupController<Publisher> {

    public PublisherController(PublisherService service) {
        super(service);
    }

    @Override
    protected Publisher createEntity() {

        return new Publisher();
    }
}
