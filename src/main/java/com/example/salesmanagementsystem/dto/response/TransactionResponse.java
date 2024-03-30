package com.example.salesmanagementsystem.dto.response;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder
public class TransactionResponse {
    @NotNull(message = "Sales Management ID must not be null")
    private Long productManagementId;

    @NotNull(message = "Transaction Management ID must not be null")
    private Long salesManagementId;

    @NotNull
    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private BigDecimal price;

    public TransactionResponse(Long productManagementId, Long salesManagementId, Integer quantity, BigDecimal price) {
        this.productManagementId = productManagementId;
        this.salesManagementId = salesManagementId;
        this.quantity = quantity;
        this.price = price;
    }
}
