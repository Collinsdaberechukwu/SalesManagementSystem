package com.example.salesmanagementsystem.model;

import com.example.salesmanagementsystem.enums.SalesPaymentMethod;
import com.example.salesmanagementsystem.enums.SalesStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class SalesManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "sales_status")
    private SalesStatus salesStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "sales_payment_method")
    private SalesPaymentMethod paymentMethod;

    @Column(name = "total_sales")
    private BigDecimal totalSales;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "client_management_fk")
    private ClientManagement clientManagement;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_fk")
    private List<TransactionManagement> transactionManagements;

}
