package com.example.salesmanagementsystem.service.implementation;

import com.example.salesmanagementsystem.dto.request.SalesCreationRequest;
import com.example.salesmanagementsystem.dto.request.SalesUpdateRequest;
import com.example.salesmanagementsystem.dto.response.SalesCreationResponse;
import com.example.salesmanagementsystem.dto.response.SalesResponse;
import com.example.salesmanagementsystem.dto.response.SalesUpdateResponse;
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
import java.util.Optional;

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

    @Override
    public ResponseEntity<SalesUpdateResponse> updateSales(Long salesId, SalesUpdateRequest salesUpdateRequest) {
        Optional<SalesManagement> optionalSales = salesManagementRepository.findById(salesId);
        if (optionalSales.isPresent()) {
            SalesManagement sales = optionalSales.get();

            if (salesUpdateRequest.getSalesStatus() != null) {
                sales.setSalesStatus(SalesStatus.valueOf(salesUpdateRequest.getSalesStatus().toUpperCase()));
            }
            if (salesUpdateRequest.getTotalSales() != null) {
                sales.setTotalSales(salesUpdateRequest.getTotalSales());
            }
            if (salesUpdateRequest.getPaymentMethod() != null) {
                sales.setPaymentMethod(SalesPaymentMethod.valueOf(String.valueOf(salesUpdateRequest.getPaymentMethod())));
            }

            if (salesUpdateRequest.getClientManagement() != null) {
                ClientManagement client = salesUpdateRequest.getClientManagement();
                sales.setClientManagement(client);
            }

            SalesManagement updatedSales = salesManagementRepository.save(sales);
            SalesUpdateResponse salesUpdateResponse = new SalesUpdateResponse(updatedSales.getId(), "Sales updated successfully");

            return ResponseEntity.ok().body(salesUpdateResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<SalesResponse> getSales(Long salesId) {
        Optional<SalesManagement> optionalSales = salesManagementRepository.findById(salesId);
        if (optionalSales.isPresent()) {
            SalesManagement sales = optionalSales.get();

            SalesResponse salesResponse = new SalesResponse(
                    sales.getId(),
                    sales.getSalesStatus(),
                    sales.getPaymentMethod(),
                    sales.getTotalSales(),
                    sales.getClientManagement(),
                    sales.getTransactionManagements()
            );

            return ResponseEntity.ok().body(salesResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> deleteSales(Long salesId) {
        Optional<SalesManagement> optionalSales = salesManagementRepository.findById(salesId);
        if (optionalSales.isPresent()) {
            salesManagementRepository.deleteById(salesId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
