package com.library.management.controller;

import com.library.management.entity.Medium;
import com.library.management.service.MediumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/mediums")
public class MediumController extends BaseLookupController<Medium> {

    public MediumController(MediumService service) {

        super(service);
    }

    protected Medium createEntity(){

        return new Medium();
    }
}
