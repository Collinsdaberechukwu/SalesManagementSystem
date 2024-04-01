package com.example.salesmanagementsystem.model;

import jakarta.persistence.*;
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
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_sales")
    private Integer totalSales;

    @Column(name = "total-revenue")
    private BigDecimal totalRevenue;

    @OneToMany
    @JoinColumn(name = "product_management")
    private List<ProductManagement> topSellingProductManagements;

    @OneToMany
    @JoinColumn(name = "client_management")
    private List<ClientManagement> topPerformingSellers;

}
