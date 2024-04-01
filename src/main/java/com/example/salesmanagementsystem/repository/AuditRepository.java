package com.example.salesmanagementsystem.repository;

import com.example.salesmanagementsystem.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit,Long> {
}
