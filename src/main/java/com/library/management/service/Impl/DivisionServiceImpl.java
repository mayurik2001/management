package com.library.management.service.Impl;

import com.library.management.entity.Division;
import com.library.management.repo.DivisionRepository;
import com.library.management.service.DivisionService;
import org.springframework.stereotype.Service;


@Service
public class DivisionServiceImpl extends BaseLookupServiceImpl<Division>
      implements DivisionService {

    public DivisionServiceImpl(DivisionRepository repository){
        super(repository);
    }

}
