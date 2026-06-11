package com.library.management.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResourceRequest {

    private String isbnBarcode;

    private String title;

    private String edition;

    private List<String> authors;

    private List<String> categories;

    private List<String> publishers;

    private Long resourceTypeId;

    private Long languageId;

    private Long roomId;

    private Long rackId;

    private Integer quantity;
}