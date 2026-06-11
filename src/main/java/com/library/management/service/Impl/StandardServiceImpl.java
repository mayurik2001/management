package com.library.management.service.Impl;

import com.library.management.entity.Standard;
import com.library.management.repo.StandardRepository;
import com.library.management.service.StandardService;
import org.springframework.stereotype.Service;


@Service
public class StandardServiceImpl extends BaseLookupServiceImpl<Standard>
          implements StandardService {

    public StandardServiceImpl(StandardRepository repository){

        super(repository);
    }
}
