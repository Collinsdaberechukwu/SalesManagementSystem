package com.example.salesmanagementsystem.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class LogCreationResponse {

    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "Log Created successfully")
    private String message;

    public LogCreationResponse(Long id, String message) {
        this.id = id;
        this.message = "Log Created successfully";
    }
}
