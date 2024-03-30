package com.example.salesmanagementsystem.service.implementation;

import com.example.salesmanagementsystem.dto.request.SalesCreationRequest;
import com.example.salesmanagementsystem.dto.response.ProductManagementCreationResponse;
import com.example.salesmanagementsystem.dto.response.SalesCreationResponse;
import com.example.salesmanagementsystem.enums.SalesPaymentMethod;
import com.example.salesmanagementsystem.enums.SalesStatus;
import com.example.salesmanagementsystem.model.ClientManagement;
import com.example.salesmanagementsystem.model.SalesManagement;
import com.example.salesmanagementsystem.repository.SalesManagementRepository;
import com.example.salesmanagementsystem.service.SalesManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class SalesManagementServiceImpl implements SalesManagementService {

    private final SalesManagementRepository salesManagementRepository;


    @Override
    public ResponseEntity<SalesCreationResponse> createSales(SalesCreationRequest salesCreationRequest){

        SalesManagement newSales = SalesManagement.builder().build();

        newSales.setSalesStatus(SalesStatus.valueOf(String.valueOf(salesCreationRequest.getSalesStatus()).toUpperCase()));
        newSales.setTotalSales(salesCreationRequest.getTotalSales());
        newSales.setPaymentMethod(SalesPaymentMethod.valueOf(String.valueOf(salesCreationRequest.getPaymentMethod())));

        ClientManagement clientManagement = new ClientManagement();
        newSales.setClientManagement(clientManagement);

        newSales.setTransactionManagements(new ArrayList<>());

        SalesManagement generatedSales =salesManagementRepository.save(newSales);

        SalesCreationResponse salesCreationResponse = new SalesCreationResponse(generatedSales.getId(), "Sales created successfully");


        return ResponseEntity.status(HttpStatus.CREATED).body(salesCreationResponse);

    }
}
