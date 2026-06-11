package com.library.management.service;

import com.library.management.DTO.ResourceRequest;
import com.library.management.DTO.ResourceResponse;

import java.util.List;

public interface ResourceService {

    ResourceResponse save(ResourceRequest request);

    List<ResourceResponse> getAll();

    ResourceResponse getById(Long id);

    ResourceResponse update(Long id, ResourceRequest request);

    String delete(Long id);

}
