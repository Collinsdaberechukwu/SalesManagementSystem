package com.example.salesmanagementsystem.dto.request;

import com.example.salesmanagementsystem.enums.LogActionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogUpdateRequest {

    @NotNull(message = "Log ID is required")
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Log action type is required")
    private LogActionType logActionType;
}
