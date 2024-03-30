package com.example.salesmanagementsystem.service;

import com.example.salesmanagementsystem.dto.request.TransactionCreationRequest;
import com.example.salesmanagementsystem.dto.response.TransactionCreationResponse;
import org.springframework.http.ResponseEntity;

public interface TransactionManagementService {

    ResponseEntity<TransactionCreationResponse> createTransaction(TransactionCreationRequest request);
}
