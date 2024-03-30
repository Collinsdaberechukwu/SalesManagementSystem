package com.example.salesmanagementsystem.service;

import com.example.salesmanagementsystem.dto.request.SalesCreationRequest;
import com.example.salesmanagementsystem.dto.request.SalesUpdateRequest;
import com.example.salesmanagementsystem.dto.response.SalesCreationResponse;
import com.example.salesmanagementsystem.dto.response.SalesResponse;
import com.example.salesmanagementsystem.dto.response.SalesUpdateResponse;
import org.springframework.http.ResponseEntity;

public interface SalesManagementService {
    ResponseEntity<SalesCreationResponse> createSales(SalesCreationRequest salesCreationRequest);

    ResponseEntity<SalesUpdateResponse> updateSales(Long salesId, SalesUpdateRequest salesUpdateRequest);

    ResponseEntity<SalesResponse> getSales(Long salesId);

    ResponseEntity<String> deleteSales(Long salesId);
}
