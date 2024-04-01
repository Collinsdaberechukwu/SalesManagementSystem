package com.example.salesmanagementsystem.controller;

import com.example.salesmanagementsystem.dto.request.AuditCreationRequest;
import com.example.salesmanagementsystem.dto.request.AuditUpdateRequest;
import com.example.salesmanagementsystem.dto.response.AuditCreationResponse;
import com.example.salesmanagementsystem.dto.response.AuditResponse;
import com.example.salesmanagementsystem.dto.response.AuditUpdateResponse;
import com.example.salesmanagementsystem.service.AuditService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/audit-management")
public class AuditController {

    private final AuditService auditService;


    @PostMapping("/create_audit")
    public ResponseEntity<AuditCreationResponse> createAudit(@Valid @RequestBody AuditCreationRequest auditCreationRequest) {
        return auditService.createAudit(auditCreationRequest);
    }

    @PutMapping("/update-audit/{auditId}")
    public ResponseEntity<AuditUpdateResponse> updateAudit(@PathVariable Long auditId, @RequestBody AuditUpdateRequest auditUpdateRequest) {
        return auditService.updateAudit(auditId, auditUpdateRequest);
    }

    @GetMapping("/achieve-audit/{auditId}")
    public ResponseEntity<AuditResponse> getAudit(@PathVariable Long auditId) {
        return auditService.getAudit(auditId);
    }

    @DeleteMapping("/delete/{auditId}")
    public ResponseEntity<String> deleteAudit(@PathVariable Long auditId) {
        return auditService.deleteAudit(auditId);
    }
}
