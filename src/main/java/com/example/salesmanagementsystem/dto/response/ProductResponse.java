package com.example.salesmanagementsystem.dto.response;

import com.example.salesmanagementsystem.enums.ProductCategory;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@Builder
public class ProductResponse {

    @NotNull(message = "Product ID is required")
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Product category is required")
    private ProductCategory productCategory;

    @NotNull(message = "Initial quantity is required")
    @Min(value = 0, message = "Initial quantity must be greater than or equal to 0")
    private Integer initialQuantity;

    @NotNull(message = "Available quantity is required")
    @Min(value = 0, message = "Available quantity must be greater than or equal to 0")
    private Integer availableQuantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
    private BigDecimal price;

    public ProductResponse(Long id, String name, String description, ProductCategory productCategory, Integer initialQuantity, Integer availableQuantity, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productCategory = productCategory;
        this.initialQuantity = initialQuantity;
        this.availableQuantity = availableQuantity;
        this.price = price;
    }
}
