package com.example.chef.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDto {

    @Min(0)
    @Schema(defaultValue = "0")
    int pageNumber;
    @Min(1)
    @Schema(defaultValue = "10")
    int pageSize;

    @Pattern(regexp = "asc|desc", message = "SortOrder must be 'asc' or 'desc'")
    @Schema(defaultValue = "asc")
    String sortOrder;

    @Schema(defaultValue = "id")
    String sortField;

}
