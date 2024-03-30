package com.example.salesmanagementsystem.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
public class TransactionCreationResponse {
    @NotNull(message = "Transaction ID cannot be null")
    private Long id;

    @NotNull(message = "Quantity cannot be null")
    private Integer quantity;

    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    @NotNull(message = "Sales management ID cannot be null")
    private Long salesManagementId;

    @NotNull(message = "Product management ID cannot be null")
    private Long productManagementId;


    public TransactionCreationResponse(Long id, Integer quantity, BigDecimal price, Long salesManagementId, Long productManagementId) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.salesManagementId = salesManagementId;
        this.productManagementId = productManagementId;
    }


}
