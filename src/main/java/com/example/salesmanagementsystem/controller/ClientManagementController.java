package com.example.salesmanagementsystem.controller;

import com.example.salesmanagementsystem.dto.request.ClientManagementCreationRequest;
import com.example.salesmanagementsystem.dto.request.ClientUpdateRequest;
import com.example.salesmanagementsystem.dto.response.ClientManagementCreationResponse;
import com.example.salesmanagementsystem.dto.response.ClientResponse;
import com.example.salesmanagementsystem.dto.response.ClientUpdateResponse;
import com.example.salesmanagementsystem.service.ClientManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client-management")
public class ClientManagementController {

    private final ClientManagementService clientManagementService;

    @PostMapping("/create-client")
    public ResponseEntity<ClientManagementCreationResponse> createClient(@Valid @RequestBody ClientManagementCreationRequest clientManagementCreationRequest){
        return clientManagementService.createClient(clientManagementCreationRequest);
    }
    @PutMapping("/update-client")
    public ResponseEntity<ClientUpdateResponse> updateClient(@Valid @RequestBody ClientUpdateRequest clientUpdateRequest){
        return clientManagementService.updateClient(clientUpdateRequest);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientResponse> getClient(@PathVariable("id") Long clientId) {
        return clientManagementService.getClient(clientId);
    }
    @DeleteMapping("/delete-client/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {
        return clientManagementService.deleteClient(id);
    }



    }
