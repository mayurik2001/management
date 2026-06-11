package com.library.management.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameRequest {

    @NotBlank(message = "Name is required")
    private String name;
}
