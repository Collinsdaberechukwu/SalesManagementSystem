package com.example.salesmanagementsystem.repository;

import com.example.salesmanagementsystem.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Long> {
}
