package com.example.salesmanagementsystem.controller;

import com.example.salesmanagementsystem.dto.request.ProductManagementCreationRequest;
import com.example.salesmanagementsystem.dto.request.ProductManagementUpdateRequest;
import com.example.salesmanagementsystem.dto.response.ProductManagementCreationResponse;
import com.example.salesmanagementsystem.dto.response.ProductManagementUpdateResponse;
import com.example.salesmanagementsystem.dto.response.ProductResponse;
import com.example.salesmanagementsystem.model.ProductManagement;
import com.example.salesmanagementsystem.service.ProductManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product-management")
public class ProductManagementController {

    private final ProductManagementService productManagementService;

    @PostMapping("/create-product")
    public ResponseEntity<ProductManagementCreationResponse> createProduct(@Valid @RequestBody ProductManagementCreationRequest productManagementCreationRequest){
        return productManagementService.createProduct(productManagementCreationRequest);
    }
    @PutMapping("/update-product")
    public ResponseEntity<ProductManagementUpdateResponse> updateProduct(@Valid @RequestBody ProductManagementUpdateRequest request) {
        ResponseEntity<ProductManagementUpdateResponse> responseEntity = productManagementService.updateProduct(request);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<Page<ProductResponse>> getProduct(@PathVariable("productId") Long productId,
                                                            @RequestParam int page,
                                                            @RequestParam int size) {
        Page<ProductResponse> products = productManagementService.getProduct(productId, page, size);
        return ResponseEntity.ok().body(products);
    }
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        return productManagementService.deleteProduct(id);
    }

    }






