package com.example.salesmanagementsystem.repository;

import com.example.salesmanagementsystem.model.TransactionManagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionManagementRepository extends JpaRepository<TransactionManagement,Long> {
}
