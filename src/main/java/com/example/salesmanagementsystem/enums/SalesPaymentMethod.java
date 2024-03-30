package com.example.salesmanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SalesPaymentMethod {

    CREDIT_CARD("CREDIT_CARD"),
    DEBIT_CARD("DEBIT_CARD"),
    BANK_TRANSFER("BANK_TRANSFER"),
    CASH_ON_DELIVERY("CASH_ON_DELIVERY"),
    PAYPAL("PAYPAL"),
    OTHER("OTHER");

    private final String salesPaymentMethod;
}
