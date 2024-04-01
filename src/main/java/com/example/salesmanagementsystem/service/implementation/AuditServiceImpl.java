package com.example.salesmanagementsystem.service.implementation;

import com.example.salesmanagementsystem.dto.request.AuditCreationRequest;
import com.example.salesmanagementsystem.dto.request.AuditUpdateRequest;
import com.example.salesmanagementsystem.dto.response.AuditCreationResponse;
import com.example.salesmanagementsystem.dto.response.AuditResponse;
import com.example.salesmanagementsystem.dto.response.AuditUpdateResponse;
import com.example.salesmanagementsystem.enums.AuditAction;
import com.example.salesmanagementsystem.enums.AuditStatus;
import com.example.salesmanagementsystem.model.Audit;
import com.example.salesmanagementsystem.repository.AuditRepository;
import com.example.salesmanagementsystem.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    @Override
    public ResponseEntity<AuditCreationResponse> createAudit(AuditCreationRequest auditCreationRequest){

        Audit newAudit = Audit.builder().build();
        newAudit.setAuditAction(AuditAction.valueOf(String.valueOf(auditCreationRequest.getAuditAction())));
        newAudit.setAuditStatus(AuditStatus.valueOf(String.valueOf(auditCreationRequest.getAuditStatus())));
        newAudit.setNewValue(auditCreationRequest.getNewValue());
        newAudit.setOldValue(auditCreationRequest.getOldValue());

        Audit savedAudit = auditRepository.save(newAudit);

        AuditCreationResponse response = new AuditCreationResponse(savedAudit.getId(), "Audit created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @Override
    public ResponseEntity<AuditUpdateResponse> updateAudit(Long auditId, AuditUpdateRequest auditUpdateRequest) {
        Optional<Audit> optionalAudit = auditRepository.findById(auditId);

        if (optionalAudit.isPresent()) {
            Audit existingAudit = optionalAudit.get();
            existingAudit.setAuditAction(AuditAction.valueOf(String.valueOf(auditUpdateRequest.getAuditAction())));
            existingAudit.setAuditStatus(AuditStatus.valueOf(String.valueOf(auditUpdateRequest.getAuditStatus())));
            existingAudit.setNewValue(auditUpdateRequest.getNewValue());
            existingAudit.setOldValue(auditUpdateRequest.getOldValue());

            Audit updatedAudit = auditRepository.save(existingAudit);

            AuditUpdateResponse response = new AuditUpdateResponse(updatedAudit.getId(), "Audit updated successfully");

            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<AuditResponse> getAudit(Long auditId) {
        Optional<Audit> optionalAudit = auditRepository.findById(auditId);

        if (optionalAudit.isPresent()) {
            Audit audit = optionalAudit.get();

            AuditResponse auditResponse = new AuditResponse();
            auditResponse.setId(audit.getId());
            auditResponse.setAuditAction(AuditAction.valueOf(audit.getAuditAction().toString()));
            auditResponse.setAuditStatus(AuditStatus.valueOf(audit.getAuditStatus().toString()));
            auditResponse.setNewValue(audit.getNewValue());
            auditResponse.setOldValue(audit.getOldValue());
            return ResponseEntity.ok().body(auditResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> deleteAudit(Long auditId) {
        Optional<Audit> optionalAudit = auditRepository.findById(auditId);

        if (optionalAudit.isPresent()) {
            auditRepository.deleteById(auditId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
