package com.example.salesmanagementsystem.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class LogUpdateResponse {
    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "Log Updated successfully")
    private String message;

    public LogUpdateResponse(Long id, String message) {
        this.id = id;
        this.message = "Log Updated successfully";
    }
}
