package com.example.salesmanagementsystem.service;

import com.example.salesmanagementsystem.dto.request.ProductManagementCreationRequest;
import com.example.salesmanagementsystem.dto.request.ProductManagementUpdateRequest;
import com.example.salesmanagementsystem.dto.response.ProductManagementCreationResponse;
import com.example.salesmanagementsystem.dto.response.ProductManagementUpdateResponse;
import com.example.salesmanagementsystem.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface ProductManagementService {
    ResponseEntity<ProductManagementCreationResponse> createProduct(ProductManagementCreationRequest productManagementCreationRequest);

    ResponseEntity<ProductManagementUpdateResponse> updateProduct(ProductManagementUpdateRequest productManagementUpdateRequest);

    Page<ProductResponse> getProduct(Long productId, int page, int size);

    ResponseEntity<String> deleteProduct(Long id);
}
