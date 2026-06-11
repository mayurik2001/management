package com.library.management.service.Impl;

import com.library.management.entity.Medium;
import com.library.management.repo.MediumRepository;
import com.library.management.service.MediumService;
import org.springframework.stereotype.Service;


@Service
public class MediumServiceImpl extends BaseLookupServiceImpl<Medium>
            implements MediumService {

    public MediumServiceImpl(MediumRepository repository){
         super(repository);
    }
}
