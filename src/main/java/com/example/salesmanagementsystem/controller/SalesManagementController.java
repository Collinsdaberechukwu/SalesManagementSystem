package com.example.salesmanagementsystem.controller;

import com.example.salesmanagementsystem.dto.request.SalesCreationRequest;
import com.example.salesmanagementsystem.dto.request.SalesUpdateRequest;
import com.example.salesmanagementsystem.dto.response.SalesCreationResponse;
import com.example.salesmanagementsystem.dto.response.SalesResponse;
import com.example.salesmanagementsystem.dto.response.SalesUpdateResponse;
import com.example.salesmanagementsystem.service.SalesManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales-management")
public class SalesManagementController {

    private final SalesManagementService salesManagementService;

    @PostMapping("/create-sales")
    public ResponseEntity<SalesCreationResponse> createSales(@Valid  @RequestBody SalesCreationRequest salesCreationRequest){
        return salesManagementService.createSales(salesCreationRequest);
    }
    @PutMapping("/update-sales/{salesId}")
    public ResponseEntity<SalesUpdateResponse> updateSales(@PathVariable Long salesId, @RequestBody SalesUpdateRequest salesUpdateRequest) {
        return salesManagementService.updateSales(salesId, salesUpdateRequest);
    }

    @GetMapping("/achieve-sales/{salesId}")
    public ResponseEntity<SalesResponse> getSales(@PathVariable Long salesId) {
        return salesManagementService.getSales(salesId);
    }

    @DeleteMapping("/delete/{salesId}")
    public ResponseEntity<String> deleteSales(@PathVariable Long salesId) {
        return salesManagementService.deleteSales(salesId);
    }
}