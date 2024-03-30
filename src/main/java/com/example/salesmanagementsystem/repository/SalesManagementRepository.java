package com.example.salesmanagementsystem.repository;

import com.example.salesmanagementsystem.model.SalesManagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesManagementRepository extends JpaRepository<SalesManagement,Long> {
}
