package com.library.management.controller;

import com.library.management.entity.Standard;
import com.library.management.service.StandardService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/standards")
public class StandardController extends BaseLookupController<Standard> {

    public StandardController(StandardService service){

        super(service);
    }

    @Override
    protected Standard createEntity(){

        return new Standard();
    }
}
