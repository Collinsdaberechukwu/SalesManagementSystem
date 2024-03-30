package com.example.salesmanagementsystem.repository;

import com.example.salesmanagementsystem.model.ProductManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductManagementRepository extends JpaRepository<ProductManagement,Long> {
    ProductManagement findProductManagementById(Long id);

    Page<ProductManagement> findAllById(Long productId, Pageable pageable);
}
