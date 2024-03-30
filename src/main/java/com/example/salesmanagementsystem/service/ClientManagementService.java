package com.example.salesmanagementsystem.service;

import com.example.salesmanagementsystem.dto.request.ClientManagementCreationRequest;
import com.example.salesmanagementsystem.dto.request.ClientUpdateRequest;
import com.example.salesmanagementsystem.dto.response.ClientManagementCreationResponse;
import com.example.salesmanagementsystem.dto.response.ClientResponse;
import com.example.salesmanagementsystem.dto.response.ClientUpdateResponse;
import org.springframework.http.ResponseEntity;

public interface ClientManagementService {
    ResponseEntity<ClientManagementCreationResponse> createClient(ClientManagementCreationRequest clientManagementCreationRequest);

    ResponseEntity<ClientUpdateResponse> updateClient(ClientUpdateRequest clientUpdateRequest);

    public ResponseEntity<ClientResponse> getClient(Long clientId);

    ResponseEntity<String> deleteClient(Long id);
}
