package com.library.management.DTO;

import com.library.management.enums.BookAssignStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class BookAssignResponse {

    private Long id;

    private Long memberId;

    private String memberName;

    private Long resourceId;

    private String resourceTitle;

    private LocalDate assignDate;

    private LocalDate returnDate;

    private BookAssignStatus status;

    private LocalDateTime assignedAt;
}
