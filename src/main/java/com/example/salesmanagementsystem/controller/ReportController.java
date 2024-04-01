package com.example.salesmanagementsystem.controller;

import com.example.salesmanagementsystem.dto.request.ReportCreationRequest;
import com.example.salesmanagementsystem.dto.request.ReportUpdateRequest;
import com.example.salesmanagementsystem.dto.response.ReportCreationResponse;
import com.example.salesmanagementsystem.dto.response.ReportResponse;
import com.example.salesmanagementsystem.dto.response.ReportUpdateResponse;
import com.example.salesmanagementsystem.service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {


    private final ReportService reportService;

    @PostMapping("/create-report")
    public ResponseEntity<ReportCreationResponse> createReport(@Valid @RequestBody ReportCreationRequest reportCreationRequest) {
        return reportService.createReport(reportCreationRequest);
    }

    @PutMapping("/update-report/{reportId}")
    public ResponseEntity<ReportUpdateResponse> updateReport(@PathVariable Long reportId, @RequestBody ReportUpdateRequest reportUpdateRequest) {
        return reportService.updateReport(reportId, reportUpdateRequest);
    }
    @GetMapping("/achieved/{reportId}")
    public ResponseEntity<ReportResponse> getReport(@PathVariable Long reportId) {
        return reportService.getReport(reportId);
    }

    @DeleteMapping("/delete/{reportId}")
    public ResponseEntity<String> deleteReport(@PathVariable Long reportId) {
        return reportService.deleteReport(reportId);
    }

}
