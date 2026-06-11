package com.library.management.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ResourceResponse {

    private Long id;

    private String isbnBarcode;

    private String title;

    private String edition;

    private List<String> authors;

    private List<String> categories;

    private List<String> publishers;

    private String resourceTypeName;

    private String languageName;

    private String roomName;

    private String rackName;

    private Integer quantity;

    private String status;

    private LocalDateTime createdAt;
}