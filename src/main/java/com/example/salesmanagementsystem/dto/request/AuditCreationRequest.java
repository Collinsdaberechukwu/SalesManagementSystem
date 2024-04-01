package com.example.salesmanagementsystem.dto.request;

import com.example.salesmanagementsystem.enums.AuditAction;
import com.example.salesmanagementsystem.enums.AuditStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditCreationRequest {
    @NotNull(message = "Audit action cannot be null")
    private AuditAction auditAction;

    @NotNull(message = "Audit status cannot be null")
    private AuditStatus auditStatus;

    @Size(max = 255, message = "Old value must be less than or equal to 255 characters")
    private String oldValue;

    @Size(max = 255, message = "New value must be less than or equal to 255 characters")
    private String newValue;
}
