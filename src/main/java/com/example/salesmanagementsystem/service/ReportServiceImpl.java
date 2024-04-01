package com.example.salesmanagementsystem.service;

import com.example.salesmanagementsystem.dto.request.ClientManagementCreationRequest;
import com.example.salesmanagementsystem.dto.request.ProductManagementCreationRequest;
import com.example.salesmanagementsystem.dto.request.ReportCreationRequest;
import com.example.salesmanagementsystem.dto.request.ReportUpdateRequest;
import com.example.salesmanagementsystem.dto.response.ReportCreationResponse;
import com.example.salesmanagementsystem.dto.response.ReportResponse;
import com.example.salesmanagementsystem.dto.response.ReportUpdateResponse;
import com.example.salesmanagementsystem.enums.ProductCategory;
import com.example.salesmanagementsystem.model.ClientManagement;
import com.example.salesmanagementsystem.model.ProductManagement;
import com.example.salesmanagementsystem.model.Report;
import com.example.salesmanagementsystem.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

    private final ReportRepository reportRepository;

    @Override
    public ResponseEntity<ReportCreationResponse> createReport(ReportCreationRequest reportCreationRequest) {
        Report newReport = new Report();
        newReport.setTotalRevenue(reportCreationRequest.getTotalRevenue());
        newReport.setTotalSales(reportCreationRequest.getTotalSales());

        newReport.setTopSellingProductManagements(mapProductManagementRequests(reportCreationRequest.getTopSellingProducts()));
        newReport.setTopPerformingSellers(mapClientManagementRequests(reportCreationRequest.getTopPerformingSellers()));

        Report savedReport = reportRepository.save(newReport);

        ReportCreationResponse response = new ReportCreationResponse(savedReport.getId(), "Report created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    private List<ProductManagement> mapProductManagementRequests(List<ProductManagementCreationRequest> productRequests) {
        return productRequests.stream()
                .map(this::mapProductManagementRequest)
                .collect(Collectors.toList());
    }

    private List<ClientManagement> mapClientManagementRequests(List<ClientManagementCreationRequest> clientRequests) {
        return clientRequests.stream()
                .map(this::mapClientManagementRequest)
                .collect(Collectors.toList());
    }

    private ProductManagement mapProductManagementRequest(ProductManagementCreationRequest productRequest) {
        ProductManagement productManagement = new ProductManagement();
        productManagement.setName(productRequest.getName());
        return productManagement;
    }

    private ClientManagement mapClientManagementRequest(ClientManagementCreationRequest clientRequest) {
        ClientManagement clientManagement = new ClientManagement();
        clientManagement.setName(clientRequest.getName());
        return clientManagement;
    }

    @Override
    public ResponseEntity<ReportUpdateResponse> updateReport(Long reportId, ReportUpdateRequest reportUpdateRequest) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);

        if (optionalReport.isPresent()) {
            Report existingReport = optionalReport.get();
            existingReport.setTotalRevenue(reportUpdateRequest.getTotalRevenue());
            existingReport.setTotalSales(reportUpdateRequest.getTotalSales());

            existingReport.setTopSellingProductManagements(mapProductManagementRequests(reportUpdateRequest.getTopSellingProducts()));
            existingReport.setTopPerformingSellers(mapClientManagementRequests(reportUpdateRequest.getTopPerformingSellers()));

            Report updatedReport = reportRepository.save(existingReport);

            ReportUpdateResponse response = new ReportUpdateResponse(updatedReport.getId(), "Report updated successfully");

            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<ReportResponse> getReport(Long reportId) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);

        return optionalReport.map(report -> {
            ReportResponse reportResponse = new ReportResponse();
            reportResponse.setTotalSales(report.getTotalSales());
            reportResponse.setTotalRevenue(report.getTotalRevenue());
            reportResponse.setTopSellingProducts(mapProductManagementResponses(report.getTopSellingProductManagements()));
            reportResponse.setTopPerformingSellers(mapClientManagementResponses(report.getTopPerformingSellers()));
            return ResponseEntity.ok().body(reportResponse);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    private List<ProductManagementCreationRequest> mapProductManagementResponses(List<ProductManagement> topSellingProductManagements) {
        return topSellingProductManagements.stream()
                .map(this::mapProductManagementResponse)
                .collect(Collectors.toList());
    }

    private ProductManagementCreationRequest mapProductManagementResponse(ProductManagement productManagement) {
        ProductManagementCreationRequest request = new ProductManagementCreationRequest();
        request.setName(productManagement.getName());
        request.setPrice(productManagement.getPrice());
        request.setDescription(productManagement.getDescription());
        request.setProductCategory(ProductCategory.valueOf(String.valueOf(productManagement.getProductCategory()).toUpperCase()));
        request.setInitialQuantity(productManagement.getInitialQuantity());
        request.setAvailableQuantity(productManagement.getAvailableQuantity());
        return request;
    }

    private List<ClientManagementCreationRequest> mapClientManagementResponses(List<ClientManagement> topPerformingSellers) {
        return topPerformingSellers.stream()
                .map(this::mapClientManagementResponse)
                .collect(Collectors.toList());
    }
    private ClientManagementCreationRequest mapClientManagementResponse(ClientManagement clientManagement) {
        ClientManagementCreationRequest request = new ClientManagementCreationRequest();
        request.setName(clientManagement.getName());
        request.setLastName(clientManagement.getLastName());
        request.setEmail(clientManagement.getEmail());
        request.setAddress(clientManagement.getAddress());
        request.setMobile(clientManagement.getMobile());
        return request;
    }

    @Override
    public ResponseEntity<String> deleteReport(Long reportId) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);

        if (optionalReport.isPresent()) {
            reportRepository.deleteById(reportId);
            return ResponseEntity.ok().body("Report deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
