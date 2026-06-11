package com.library.management.service.Impl;

import com.library.management.DTO.MemberRestrictionRequest;
import com.library.management.DTO.MemberRestrictionResponse;
import com.library.management.service.MemberRestrictionService;
import org.springframework.stereotype.Service;
import com.library.management.entity.Member;
import com.library.management.entity.MemberRestriction;
import com.library.management.repo.MemberRepository;
import com.library.management.repo.MemberRestrictionRepository;


import java.util.List;

@Service
public class MemberRestrictionServiceImpl implements MemberRestrictionService {

    private final MemberRestrictionRepository repository;

    private final MemberRepository memberRepository;

    public MemberRestrictionServiceImpl(
            MemberRestrictionRepository repository,
            MemberRepository memberRepository) {

        this.repository = repository;
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberRestrictionResponse create(
            MemberRestrictionRequest request) {

        Member member =
                memberRepository.findById(
                                request.getMemberId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Member not found"));

        MemberRestriction restriction =
                new MemberRestriction();

        restriction.setMember(member);

        restriction.setRestrictionType(
                request.getRestrictionType());

        restriction.setDescription(
                request.getDescription());

        MemberRestriction saved =
                repository.save(restriction);

        return mapToDTO(saved);
    }

    @Override
    public List<MemberRestrictionResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public MemberRestrictionResponse getById(
            Long id) {

        MemberRestriction restriction =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restriction not found"));

        return mapToDTO(restriction);
    }

    @Override
    public MemberRestrictionResponse update(
            Long id,
            MemberRestrictionRequest request) {

        MemberRestriction restriction =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restriction not found"));

        restriction.setRestrictionType(
                request.getRestrictionType());

        restriction.setDescription(
                request.getDescription());

        MemberRestriction updated =
                repository.save(restriction);

        return mapToDTO(updated);
    }

    @Override
    public MemberRestrictionResponse activate(
            Long id) {

        MemberRestriction restriction =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restriction not found"));

        restriction.setActive(true);

        return mapToDTO(
                repository.save(restriction));
    }

    @Override
    public MemberRestrictionResponse deactivate(
            Long id) {

        MemberRestriction restriction =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restriction not found"));

        restriction.setActive(false);

        return mapToDTO(
                repository.save(restriction));
    }

    private MemberRestrictionResponse mapToDTO(
            MemberRestriction restriction) {

        MemberRestrictionResponse response =
                new MemberRestrictionResponse();

        response.setId(
                restriction.getId());

        response.setMemberId(
                restriction.getMember().getId());

        response.setMemberName(
                restriction.getMember().getName());

        response.setRestrictionType(
                restriction.getRestrictionType());

        response.setDescription(
                restriction.getDescription());

        response.setActive(
                restriction.getActive());

        response.setCreatedAt(
                restriction.getCreatedAt());

        return response;
    }
}
