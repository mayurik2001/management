package com.library.management.service.Impl;

import com.library.management.entity.Rack;
import com.library.management.repo.RackRepository;
import com.library.management.service.RackService;
import org.springframework.stereotype.Service;


@Service
public class RackServiceImpl extends BaseLookupServiceImpl<Rack>
           implements RackService {

    public RackServiceImpl(RackRepository repository){
        super(repository);
    }
}
