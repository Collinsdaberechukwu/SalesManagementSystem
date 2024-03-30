package com.example.salesmanagementsystem.repository;

import com.example.salesmanagementsystem.model.ClientManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientManagementRepository extends JpaRepository<ClientManagement,Long> {
    @Query("SELECT COUNT(c) > 0 FROM ClientManagement c WHERE c.email = ?1 AND c.mobile = ?2")
    boolean existsClientManagementByEmailAndMobile(String email, String mobile);

    Optional<ClientManagement> findClientManagementById(Long clientId);
}
