package com.example.salesmanagementsystem.service.implementation;

import com.example.salesmanagementsystem.dto.request.TransactionCreationRequest;
import com.example.salesmanagementsystem.dto.response.TransactionCreationResponse;
import com.example.salesmanagementsystem.model.TransactionManagement;
import com.example.salesmanagementsystem.repository.ProductManagementRepository;
import com.example.salesmanagementsystem.repository.SalesManagementRepository;
import com.example.salesmanagementsystem.repository.TransactionManagementRepository;
import com.example.salesmanagementsystem.service.TransactionManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionManagementServiceImpl implements TransactionManagementService {

    private final TransactionManagementRepository transactionManagementRepository;
    private final SalesManagementRepository salesManagementRepository;
    private final ProductManagementRepository productManagementRepository;

    @Override
    public ResponseEntity<TransactionCreationResponse> createTransaction(TransactionCreationRequest request) {
        TransactionManagement transaction = new TransactionManagement();
        transaction.setQuantity(request.getQuantity());
        transaction.setPrice(request.getPrice());
        transaction.setSalesManagement(salesManagementRepository.findById(request.getSalesManagementId())
                .orElseThrow(() -> new RuntimeException ("Sales Management not found with id: " + request.getSalesManagementId())));
        transaction.setProductManagement(productManagementRepository.findById(request.getProductManagementId())
                .orElseThrow(() -> new RuntimeException ("Product Management not found with id: " + request.getProductManagementId())));

        TransactionManagement savedTransaction = transactionManagementRepository.save(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToTransactionCreationResponse(savedTransaction));
    }

    private TransactionCreationResponse mapToTransactionCreationResponse(TransactionManagement transaction) {
        return new TransactionCreationResponse(
                transaction.getId(),
                transaction.getQuantity(),
                transaction.getPrice(),
                transaction.getSalesManagement().getId(),
                transaction.getProductManagement().getId()
        );
    }


}
