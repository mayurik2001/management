package com.library.management.controller;

import com.library.management.DTO.ResourceRequest;
import com.library.management.DTO.ResourceResponse;
import com.library.management.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lms/resources")
public class ResourceController {

    private final ResourceService resourceService;
     public ResourceController(ResourceService resourceService){
         this.resourceService=resourceService;
     }

     @PostMapping
    public ResourceResponse saveResource(@RequestBody ResourceRequest request){

         return resourceService.save(request);

     }

     @GetMapping
     public List<ResourceResponse> getAll() {
         return resourceService.getAll();
       }

    @GetMapping("/{id}")
    public ResourceResponse getById(
            @PathVariable Long id) {

        return resourceService.getById(id);
    }

    @PutMapping("/{id}")
    public ResourceResponse update(
            @PathVariable Long id,
            @RequestBody ResourceRequest request) {

        return resourceService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id) {

        resourceService.delete(id);

        return "Resource deleted successfully";
    }
}

