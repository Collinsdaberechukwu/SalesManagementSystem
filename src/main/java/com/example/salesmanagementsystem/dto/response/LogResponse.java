package com.example.salesmanagementsystem.dto.response;

import com.example.salesmanagementsystem.enums.LogActionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class LogResponse {
    @NotNull(message = "Log ID is required")
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Log action type is required")
    private LogActionType logActionType;

    public LogResponse(Long id, String name, LogActionType logActionType) {
        this.id = id;
        this.name = name;
        this.logActionType = logActionType;
    }
}
