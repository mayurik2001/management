package com.library.management.DTO;

import com.library.management.enums.RestrictionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberRestrictionResponse {

    private Long id;

    private Long memberId;

    private String memberName;

    private RestrictionType restrictionType;

    private String description;

    private Boolean active;

    private LocalDateTime createdAt;
}