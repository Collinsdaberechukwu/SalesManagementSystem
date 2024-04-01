package com.example.salesmanagementsystem.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportUpdateRequest {

    @NotNull(message = "Log ID is required")
    private Long id;

    @Min(value = 0, message = "Total sales must be a non-negative number")
    private Integer totalSales;

    @NotNull(message = "Total revenue cannot be null")
    private BigDecimal totalRevenue;

    @NotEmpty(message = "Top selling products list cannot be empty")
    private List<ProductManagementCreationRequest> topSellingProducts;

    @NotEmpty(message = "Top performing sellers list cannot be empty")
    private List<ClientManagementCreationRequest> topPerformingSellers;


}
