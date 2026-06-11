package com.library.management.DTO;

import com.library.management.entity.AcademicYear;
import com.library.management.entity.Division;
import com.library.management.entity.Medium;
import com.library.management.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse {

    private Long id;

    private String name;

    private String mobileNo;

    private String email;

    private AcademicYear academicYear;

    private String className;

    private Division division;

    private String rollNo;

    private Medium medium;

    private Gender gender;

    private String profilePhoto;
}
