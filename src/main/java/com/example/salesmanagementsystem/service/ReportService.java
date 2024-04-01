package com.example.salesmanagementsystem.service;

import com.example.salesmanagementsystem.dto.request.ReportCreationRequest;
import com.example.salesmanagementsystem.dto.request.ReportUpdateRequest;
import com.example.salesmanagementsystem.dto.response.ReportCreationResponse;
import com.example.salesmanagementsystem.dto.response.ReportResponse;
import com.example.salesmanagementsystem.dto.response.ReportUpdateResponse;
import org.springframework.http.ResponseEntity;

public interface ReportService {
    ResponseEntity<ReportCreationResponse> createReport(ReportCreationRequest reportCreationRequest);

    ResponseEntity<ReportUpdateResponse> updateReport(Long reportId, ReportUpdateRequest reportUpdateRequest);

    //    @Override
    //    public ResponseEntity<ReportResponse> getReport(Long reportId) {
    //        Optional<Report> optionalReport = reportRepository.findById(reportId);
    //
    //        return optionalReport.map(report -> {
    //            ReportResponse reportResponse = new ReportResponse();
    //            reportResponse.setTotalSales(report.getTotalSales());
    //            reportResponse.setTotalRevenue(report.getTotalRevenue());
    //            reportResponse.setTopSellingProducts(mapProductManagementResponses(report.getTopSellingProductManagements()));
    //            reportResponse.setTopPerformingSellers(mapClientManagementResponses(report.getTopPerformingSellers()));
    //            return ResponseEntity.ok().body(reportResponse);
    //        }).orElseGet(() -> ResponseEntity.notFound().build());
    //}
    //
    //    private List<ProductManagementCreationRequest> mapProductManagementResponses(List<ProductManagement> topSellingProductManagements) {
    //    }
    ResponseEntity<ReportResponse> getReport(Long reportId);

    ResponseEntity<String> deleteReport(Long reportId);
}
