package com.library.management.controller;

import com.library.management.entity.Rack;
import com.library.management.service.RackService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/racks")
public class RackController extends BaseLookupController<Rack> {

    public RackController(RackService service){

        super(service);
    }

    @Override
    protected Rack createEntity(){

        return new Rack();
    }
}
