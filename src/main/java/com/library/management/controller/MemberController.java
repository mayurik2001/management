package com.library.management.controller;

import com.library.management.DTO.MemberRequest;
import com.library.management.DTO.MemberResponse;
import com.library.management.service.MemberService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("lms/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service){
        this.service=service;
    }

    @PostMapping("/formdata")
     public MemberResponse saveMember(@ModelAttribute MemberRequest request,
                                      @RequestParam MultipartFile profilePhoto) throws IOException {

        return service.saveMember(request,profilePhoto);
    }

    @GetMapping
    public List<MemberResponse> getAllMembers(){
        return service.getAllMembers();
    }

    @GetMapping("/{id}")
    public MemberResponse getMemberById(@PathVariable Long id){

        return service.getMemberById(id);
    }

    @PutMapping("/{id}")
    public MemberResponse updateMember(@PathVariable Long id,
                               @ModelAttribute MemberRequest member,
                               @RequestParam(required = false) MultipartFile profilePhoto) throws IOException{
         return service.updateMember(id,member,profilePhoto);
    }

    @DeleteMapping
    public String deleteMember(Long id){

        return service.deleteMember(id);
    }

}
