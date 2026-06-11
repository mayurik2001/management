package com.library.management.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardCountDTO {

    private Long members;

    private Long booksAssigned;

    private Long combined;
}
