package com.library.management.service.Impl;

import com.library.management.entity.AcademicYear;
import com.library.management.repo.AcademicYearRepository;
import com.library.management.service.AcademicYearService;
import org.springframework.stereotype.Service;


@Service
public class AcademicYearServiceImpl extends BaseLookupServiceImpl<AcademicYear>
        implements AcademicYearService {

    public AcademicYearServiceImpl(AcademicYearRepository repository){
        super(repository);
    }

}
