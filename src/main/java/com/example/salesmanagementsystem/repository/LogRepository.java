package com.example.salesmanagementsystem.repository;

import com.example.salesmanagementsystem.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log,Long> {
}
