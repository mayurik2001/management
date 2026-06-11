package com.library.management.service.Impl;

import com.library.management.DTO.MemberRequest;
import com.library.management.DTO.MemberResponse;
import com.library.management.entity.Member;
import com.library.management.repo.MemberRepository;
import com.library.management.service.AwsS3Service;
import com.library.management.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
    public class MemberServiceImpl implements MemberService {

        private final MemberRepository repository;
        private final AwsS3Service awsS3Service;

        public MemberServiceImpl(
                MemberRepository repository,
                AwsS3Service awsS3Service) {

            this.repository = repository;
            this.awsS3Service = awsS3Service;
        }

        @Override
        public MemberResponse saveMember(MemberRequest request, MultipartFile profilePhoto) throws IOException {

            if (repository.existsByMobileNo(
                    request.getMobileNo())) {

                throw new RuntimeException(
                        "Mobile number already exists");
            }

            Member member = new Member();

            mapMember(member, request);

            if (profilePhoto != null
                    && !profilePhoto.isEmpty()) {

                String imageUrl =
                        awsS3Service.uploadFile(
                                profilePhoto);

                member.setProfilePhoto(imageUrl);
            }

            Member saved =
                    repository.save(member);

            return mapToDTO(saved);
        }

        @Override
        public List<MemberResponse> getAllMembers() {

            return repository.findAll()
                    .stream()
                    .map(this::mapToDTO)
                    .toList();
        }

        @Override
        public MemberResponse getMemberById(Long id) {

            Member member = repository.findById(id)
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Member not found"));

            return mapToDTO(member);
        }

        @Override
        public MemberResponse updateMember(
                Long id,
                MemberRequest request,
                MultipartFile profilePhoto)
                throws IOException {

            Member member = repository.findById(id)
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Member not found"));

            mapMember(member, request);

            if (profilePhoto != null
                    && !profilePhoto.isEmpty()) {

                String imageUrl =
                        awsS3Service.uploadFile(
                                profilePhoto);

                member.setProfilePhoto(imageUrl);
            }

            Member updated =
                    repository.save(member);

            return mapToDTO(updated);
        }

        @Override
        public String deleteMember(Long id) {

            if (!repository.existsById(id)) {

                throw new RuntimeException(
                        "Member not found");
            }

            repository.deleteById(id);

            return "Member deleted successfully";
        }

        private void mapMember(
                Member member,
                MemberRequest request) {

            member.setName(request.getName());

            member.setMobileNo(
                    request.getMobileNo());

            member.setEmail(
                    request.getEmail());

            member.setAcademicYear(
                    request.getAcademicYear());

            member.setClassName(
                    request.getClassName());

            member.setDivision(
                    request.getDivision());

            member.setRollNo(
                    request.getRollNo());

            member.setMedium(
                    request.getMedium());

            member.setGender(
                    request.getGender());
        }

        private MemberResponse mapToDTO(
                Member member) {

            MemberResponse response =
                    new MemberResponse();

            response.setId(member.getId());

            response.setName(
                    member.getName());

            response.setMobileNo(
                    member.getMobileNo());

            response.setEmail(
                    member.getEmail());

            response.setAcademicYear(
                    member.getAcademicYear());

            response.setClassName(
                    member.getClassName());

            response.setDivision(
                    member.getDivision());

            response.setRollNo(
                    member.getRollNo());

            response.setMedium(
                    member.getMedium());

            response.setGender(
                    member.getGender());

            response.setProfilePhoto(
                    member.getProfilePhoto());

            return response;
        }
    }