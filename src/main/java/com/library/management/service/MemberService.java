package com.library.management.service;

import com.library.management.DTO.MemberRequest;
import com.library.management.DTO.MemberResponse;
import com.library.management.entity.Member;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MemberService {

    MemberResponse saveMember(
            MemberRequest request,
            MultipartFile profilePhoto)
            throws IOException;

    List<MemberResponse> getAllMembers();

    MemberResponse getMemberById(Long id);

    MemberResponse updateMember(Long id, MemberRequest request, MultipartFile profilePhoto) throws IOException;

    String deleteMember(Long id);
}
