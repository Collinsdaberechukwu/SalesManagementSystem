package com.example.salesmanagementsystem.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ReportCreationResponse {
    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "Report Created successfully")
    private String message;

    public ReportCreationResponse(Long id, String message) {
        this.id = id;
        this.message = "Report Created successfully";
    }
}
