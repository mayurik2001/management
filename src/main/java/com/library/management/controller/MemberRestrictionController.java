package com.library.management.controller;

import com.library.management.DTO.MemberRestrictionRequest;
import com.library.management.DTO.MemberRestrictionResponse;
import com.library.management.service.MemberRestrictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lms/member-restriction")
public class MemberRestrictionController {

        private final MemberRestrictionService service;

        public MemberRestrictionController(MemberRestrictionService service) {
            this.service = service;
        }

        @PostMapping
        public MemberRestrictionResponse create(
                @RequestBody MemberRestrictionRequest request) {

            return service.create(request);
        }

        @GetMapping
        public List<MemberRestrictionResponse> getAll() {

            return service.getAll();
        }

        @GetMapping("/{id}")
        public MemberRestrictionResponse getById(
                @PathVariable Long id) {

            return service.getById(id);
        }

        @PutMapping("/{id}")
        public MemberRestrictionResponse update(
                @PathVariable Long id,
                @RequestBody MemberRestrictionRequest request) {

            return service.update(id, request);
        }

        @PutMapping("/{id}/activate")
        public MemberRestrictionResponse activate(
                @PathVariable Long id) {

            return service.activate(id);
        }

        @PutMapping("/{id}/deactivate")
        public MemberRestrictionResponse deactivate(
                @PathVariable Long id) {

            return service.deactivate(id);
        }
}

