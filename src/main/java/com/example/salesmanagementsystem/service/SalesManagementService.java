package com.example.salesmanagementsystem.service;

import com.example.salesmanagementsystem.dto.request.SalesCreationRequest;
import com.example.salesmanagementsystem.dto.response.SalesCreationResponse;
import org.springframework.http.ResponseEntity;

public interface SalesManagementService {
    ResponseEntity<SalesCreationResponse> createSales(SalesCreationRequest salesCreationRequest);
}
