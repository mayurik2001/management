package com.library.management.service.Impl;

import com.library.management.entity.Floor;
import com.library.management.repo.FloorRepository;
import com.library.management.service.FloorService;
import org.springframework.stereotype.Service;


@Service
public class FloorServiceImpl extends BaseLookupServiceImpl<Floor>
        implements FloorService {

    public FloorServiceImpl(FloorRepository repository) {

        super(repository);

    }
}
