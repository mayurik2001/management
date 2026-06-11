package com.library.management.DTO;

import com.library.management.enums.RestrictionType;
import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class MemberRestrictionRequest {

        private Long memberId;

        private RestrictionType restrictionType;

        private String description;
    }
