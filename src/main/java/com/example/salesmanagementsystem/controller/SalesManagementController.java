package com.example.salesmanagementsystem.controller;

import com.example.salesmanagementsystem.dto.request.SalesCreationRequest;
import com.example.salesmanagementsystem.dto.response.SalesCreationResponse;
import com.example.salesmanagementsystem.service.SalesManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales-management")
public class SalesManagementController {

    private final SalesManagementService salesManagementService;

    @PostMapping("/create-sales")
    public ResponseEntity<SalesCreationResponse> createSales(@Valid  @RequestBody SalesCreationRequest salesCreationRequest){
        return salesManagementService.createSales(salesCreationRequest);
    }

    }
