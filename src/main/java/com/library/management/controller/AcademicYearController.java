package com.library.management.controller;

import com.library.management.entity.AcademicYear;
import com.library.management.service.AcademicYearService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/academic-years")
public class AcademicYearController extends BaseLookupController<AcademicYear> {

    public AcademicYearController(AcademicYearService service) {
        super(service);
    }

    @Override
    protected AcademicYear createEntity() {

        return new AcademicYear();
    }

}
