package com.example.salesmanagementsystem.controller;

import com.example.salesmanagementsystem.dto.request.TransactionCreationRequest;
import com.example.salesmanagementsystem.dto.response.TransactionCreationResponse;
import com.example.salesmanagementsystem.service.TransactionManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionManagementController {

    private final TransactionManagementService transactionManagementService;

    @PostMapping("/create-transaction")
    public ResponseEntity<TransactionCreationResponse> createTransaction(@Valid @RequestBody TransactionCreationRequest request) {
        return transactionManagementService.createTransaction(request);
    }


}

