package com.example.salesmanagementsystem.dto.response;

import com.example.salesmanagementsystem.enums.AuditAction;
import com.example.salesmanagementsystem.enums.AuditStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class AuditResponse {
    @NotNull(message = "Audit ID is required")
    private Long id;

    @NotNull(message = "Audit action cannot be null")
    private AuditAction auditAction;

    @NotNull(message = "Audit status cannot be null")
    private AuditStatus auditStatus;

    @Size(max = 255, message = "Old value must be less than or equal to 255 characters")
    private String oldValue;

    @Size(max = 255, message = "New value must be less than or equal to 255 characters")
    private String newValue;

    public AuditResponse(Long id, AuditAction auditAction, AuditStatus auditStatus, String oldValue, String newValue) {
        this.id = id;
        this.auditAction = auditAction;
        this.auditStatus = auditStatus;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }


}
