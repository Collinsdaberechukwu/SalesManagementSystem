package com.example.salesmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Report {
    private int totalSales;

    private BigDecimal totalRevenue;

    private List<ProductManagement> topSellingProductManagements;

    private List<ClientManagement> topPerformingSellers;
}
