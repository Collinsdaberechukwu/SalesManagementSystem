package com.example.salesmanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductCategory {

    ELECTRONICS("ELECTRONICS"),
    CLOTHING("CLOTHING"),
    FOOD("FOOD");

    private final String productCategory;

    public String toUpperCase() {
        return this.productCategory.toUpperCase();
    }
}
