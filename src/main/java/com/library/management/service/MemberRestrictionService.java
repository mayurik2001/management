package com.library.management.service;

import com.library.management.DTO.MemberRestrictionRequest;
import com.library.management.DTO.MemberRestrictionResponse;

import java.util.List;

public interface MemberRestrictionService {

    MemberRestrictionResponse create(
            MemberRestrictionRequest request);

    List<MemberRestrictionResponse> getAll();

    MemberRestrictionResponse getById(Long id);

    MemberRestrictionResponse update(
            Long id,
            MemberRestrictionRequest request);

    MemberRestrictionResponse activate(Long id);

    MemberRestrictionResponse deactivate(Long id);
}
