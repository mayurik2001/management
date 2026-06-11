package com.library.management.controller;

import com.library.management.entity.Division;
import com.library.management.service.DivisionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/divisions")
public class DivisionController extends BaseLookupController<Division> {

    public DivisionController(DivisionService service){
        super(service);
    }

    @Override
    protected Division createEntity(){
        return new Division();
    }
}
