package com.example.salesmanagementsystem.service;

import com.example.salesmanagementsystem.dto.request.TransactionCreationRequest;
import com.example.salesmanagementsystem.dto.request.TransactionUpdateRequest;
import com.example.salesmanagementsystem.dto.response.TransactionCreationResponse;
import com.example.salesmanagementsystem.dto.response.TransactionResponse;
import com.example.salesmanagementsystem.dto.response.TransactionUpdateResponse;
import org.springframework.http.ResponseEntity;

public interface TransactionManagementService {

    ResponseEntity<TransactionCreationResponse> createTransaction(TransactionCreationRequest request);

    ResponseEntity<TransactionUpdateResponse> updateTransaction(Long id, TransactionUpdateRequest transactionUpdateRequest);

    ResponseEntity<TransactionResponse> getTransaction(Long id);

    ResponseEntity<String> deleteTransaction(Long id);
}
