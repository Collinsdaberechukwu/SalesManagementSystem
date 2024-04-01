package com.example.salesmanagementsystem.dto.response;

import com.example.salesmanagementsystem.dto.request.ClientManagementCreationRequest;
import com.example.salesmanagementsystem.dto.request.ProductManagementCreationRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
@Builder
public class ReportResponse {

    @Min(value = 0, message = "Total sales must be a non-negative number")
    private Integer totalSales;

    @NotNull(message = "Total revenue cannot be null")
    private BigDecimal totalRevenue;

    @NotEmpty(message = "Top selling products list cannot be empty")
    private List<ProductManagementCreationRequest> topSellingProducts;

    @NotEmpty(message = "Top performing sellers list cannot be empty")
    private List<ClientManagementCreationRequest> topPerformingSellers;

    public ReportResponse(int totalSales, BigDecimal totalRevenue, List<ProductManagementCreationRequest> topSellingProducts, List<ClientManagementCreationRequest> topPerformingSellers) {
        this.totalSales = totalSales;
        this.totalRevenue = totalRevenue;
        this.topSellingProducts = topSellingProducts;
        this.topPerformingSellers = topPerformingSellers;
    }
}
