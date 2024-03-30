package com.example.salesmanagementsystem.service.implementation;

import com.example.salesmanagementsystem.dto.request.TransactionCreationRequest;
import com.example.salesmanagementsystem.dto.request.TransactionUpdateRequest;
import com.example.salesmanagementsystem.dto.response.TransactionCreationResponse;
import com.example.salesmanagementsystem.dto.response.TransactionResponse;
import com.example.salesmanagementsystem.dto.response.TransactionUpdateResponse;
import com.example.salesmanagementsystem.model.TransactionManagement;
import com.example.salesmanagementsystem.repository.ProductManagementRepository;
import com.example.salesmanagementsystem.repository.SalesManagementRepository;
import com.example.salesmanagementsystem.repository.TransactionManagementRepository;
import com.example.salesmanagementsystem.service.TransactionManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public ResponseEntity<TransactionUpdateResponse> updateTransaction(Long id, TransactionUpdateRequest transactionUpdateRequest) {
        TransactionManagement transaction = transactionManagementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));

        transaction.setQuantity(transactionUpdateRequest.getQuantity());
        transaction.setPrice(transactionUpdateRequest.getPrice());
        transaction.setSalesManagement(salesManagementRepository.findById(transactionUpdateRequest.getSalesManagementId())
                .orElseThrow(() -> new RuntimeException ("Sales Management not found with id: " + transactionUpdateRequest.getSalesManagementId())));
        transaction.setProductManagement(productManagementRepository.findById(transactionUpdateRequest.getProductManagementId())
                .orElseThrow(() -> new RuntimeException ("Product Management not found with id: " + transactionUpdateRequest.getProductManagementId())));

        transaction = transactionManagementRepository.save(transaction);

        TransactionUpdateResponse response = mapToTransactionUpdateResponse(transaction);
        return ResponseEntity.ok(response);
    }

    private TransactionUpdateResponse mapToTransactionUpdateResponse(TransactionManagement transaction) {
        return new TransactionUpdateResponse(transaction.getId(), "Transaction updated successfully.");
    }


    @Override
    public ResponseEntity<TransactionResponse> getTransaction(Long id) {
        TransactionManagement transaction = transactionManagementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));

        TransactionResponse response = mapToTransactionResponse(transaction);
        return ResponseEntity.ok(response);
    }

    private TransactionResponse mapToTransactionResponse(TransactionManagement transaction) {
        return new TransactionResponse(
                transaction.getProductManagement().getId(),
                transaction.getSalesManagement().getId(),
                transaction.getQuantity(),
                transaction.getPrice()
        );
    }

    @Override
    public ResponseEntity<String> deleteTransaction(Long id) {
        Optional<TransactionManagement> transactionOptional = transactionManagementRepository.findById(id);
        if (transactionOptional.isPresent()) {
            transactionManagementRepository.deleteById(id);
            return ResponseEntity.ok("Transaction with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
