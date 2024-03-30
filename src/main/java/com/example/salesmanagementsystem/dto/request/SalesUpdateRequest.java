package com.example.salesmanagementsystem.dto.request;

import com.example.salesmanagementsystem.enums.SalesPaymentMethod;
import com.example.salesmanagementsystem.enums.SalesStatus;
import com.example.salesmanagementsystem.model.ClientManagement;
import com.example.salesmanagementsystem.model.TransactionManagement;
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
public class SalesUpdateRequest {

    @NotNull(message = "ID must not be null")
    private Long id;

    @NotNull(message = "Sales status must not be null")
    private SalesStatus salesStatus;

    @NotNull(message = "Payment method must not be null")
    private SalesPaymentMethod paymentMethod;

    @NotNull(message = "Total sales must not be null")
    private BigDecimal totalSales;

    @NotNull(message = "Client management must not be null")
    private ClientManagement clientManagement;

    @NotNull(message = "Transaction managements list must not be null")
    @NotEmpty(message = "Transaction managements list must not be empty")
    private List<TransactionManagement> transactionManagements;
}
