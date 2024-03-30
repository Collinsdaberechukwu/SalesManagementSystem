package com.example.salesmanagementsystem.dto.response;

import com.example.salesmanagementsystem.enums.SalesPaymentMethod;
import com.example.salesmanagementsystem.enums.SalesStatus;
import com.example.salesmanagementsystem.model.ClientManagement;
import com.example.salesmanagementsystem.model.TransactionManagement;
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
public class SalesResponse {
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

    public SalesResponse(Long id, SalesStatus salesStatus, SalesPaymentMethod paymentMethod,
                         BigDecimal totalSales, ClientManagement clientManagement,
                         List<TransactionManagement> transactionManagements) {
        this.id = id;
        this.salesStatus = salesStatus;
        this.paymentMethod = paymentMethod;
        this.totalSales = totalSales;
        this.clientManagement = clientManagement;
        this.transactionManagements = transactionManagements;
    }
}
