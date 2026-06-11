package com.library.management.controller;

import com.library.management.entity.Room;
import com.library.management.service.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/rooms")
public class RoomController extends BaseLookupController<Room> {
         public RoomController(RoomService service){

             super(service);
         }

         @Override
       protected Room createEntity(){

             return new Room();
         }
}
