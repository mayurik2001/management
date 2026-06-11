package com.library.management.DTO;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookAssignRequest {

    private Long memberId;

    private Long resourceId;

    private LocalDate assignDate;

    private LocalDate returnDate;
}