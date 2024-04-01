package com.example.salesmanagementsystem.service;

import com.example.salesmanagementsystem.dto.request.AuditCreationRequest;
import com.example.salesmanagementsystem.dto.request.AuditUpdateRequest;
import com.example.salesmanagementsystem.dto.response.AuditCreationResponse;
import com.example.salesmanagementsystem.dto.response.AuditResponse;
import com.example.salesmanagementsystem.dto.response.AuditUpdateResponse;
import org.springframework.http.ResponseEntity;

public interface AuditService {
    ResponseEntity<AuditCreationResponse> createAudit(AuditCreationRequest auditCreationRequest);

    ResponseEntity<AuditUpdateResponse> updateAudit(Long auditId, AuditUpdateRequest auditUpdateRequest);

    ResponseEntity<AuditResponse> getAudit(Long auditId);

    ResponseEntity<String> deleteAudit(Long auditId);
}
