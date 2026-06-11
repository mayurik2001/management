package com.library.management.controller;


import com.library.management.entity.Floor;

import com.library.management.service.FloorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/floors")
    public class FloorController extends BaseLookupController<Floor> {

        public FloorController(FloorService service){

            super(service);
        }

        @Override
        protected Floor createEntity(){

            return new Floor();
        }
}
