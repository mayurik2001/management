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

    private List<Long> authorIds;

    private List<Long> categoryIds;

    private Long publisherId;

    private Long resourceTypeId;

    private Long languageId;

    private Long roomId;

    private Long rackId;

    private Integer quantity;
}