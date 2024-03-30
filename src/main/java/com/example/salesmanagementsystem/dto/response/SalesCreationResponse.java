package com.example.salesmanagementsystem.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Builder
public class SalesCreationResponse {

    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "Sales Created successfully")
    private String message;

    public SalesCreationResponse(Long id, String message) {
        this.id = id;
        this.message = "Sales Created successfully";
    }
}
