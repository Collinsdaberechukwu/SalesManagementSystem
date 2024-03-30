package com.example.salesmanagementsystem.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class SalesUpdateResponse {
    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "Sales Updated successfully")
    private String message;

    public SalesUpdateResponse(Long id, String message) {
        this.id = id;
        this.message = "Sales Updated successfully";
    }
}
