package com.example.salesmanagementsystem.service.implementation;

import com.example.salesmanagementsystem.dto.request.ClientManagementCreationRequest;
import com.example.salesmanagementsystem.dto.request.ClientUpdateRequest;
import com.example.salesmanagementsystem.dto.response.ClientManagementCreationResponse;
import com.example.salesmanagementsystem.dto.response.ClientResponse;
import com.example.salesmanagementsystem.dto.response.ClientUpdateResponse;
import com.example.salesmanagementsystem.model.ClientManagement;
import com.example.salesmanagementsystem.repository.ClientManagementRepository;
import com.example.salesmanagementsystem.service.ClientManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientManagementServiceImpl implements ClientManagementService {

    private final ClientManagementRepository clientManagementRepository;

    @Override
    public ResponseEntity<ClientManagementCreationResponse> createClient(ClientManagementCreationRequest clientManagementCreationRequest){
        if (clientManagementRepository.existsClientManagementByEmailAndMobile(
                clientManagementCreationRequest.getEmail(),
                clientManagementCreationRequest.getMobile())) {
            throw new RuntimeException("Client already exists in the database");
        }

        ClientManagement newClient = ClientManagement.builder().build();
        newClient.setName(clientManagementCreationRequest.getName());
        newClient.setLastName(clientManagementCreationRequest.getLastName());
        newClient.setAddress(clientManagementCreationRequest.getAddress());
        newClient.setMobile(clientManagementCreationRequest.getMobile());
        newClient.setEmail(clientManagementCreationRequest.getEmail());
        ClientManagement createdClient = clientManagementRepository.save(newClient);

        ClientManagementCreationResponse clientCreatedSuccessfully = new ClientManagementCreationResponse(createdClient.getId(),"Client created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(clientCreatedSuccessfully);
    }

    @Override
    public ResponseEntity<ClientUpdateResponse> updateClient(ClientUpdateRequest clientUpdateRequest) {
        Optional<ClientManagement> optionalClient = clientManagementRepository.findById(clientUpdateRequest.getId());

        if (optionalClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ClientManagement updateClients = optionalClient.get();
        updateClients.setName(clientUpdateRequest.getName());
        updateClients.setLastName(clientUpdateRequest.getLastName());
        updateClients.setEmail(clientUpdateRequest.getEmail());
        updateClients.setAddress(clientUpdateRequest.getAddress());
        updateClients.setMobile(clientUpdateRequest.getMobile());

        ClientManagement updatedClient = clientManagementRepository.save(updateClients);

        ClientUpdateResponse clientUpdateResponse = new ClientUpdateResponse(updatedClient.getId(), "Client Updated Successfully");
        return ResponseEntity.ok(clientUpdateResponse);
    }


    @Override
    public ResponseEntity<ClientResponse> getClient(Long clientId) {
        ClientManagement clientManagement = clientManagementRepository.findClientManagementById(clientId).get();
        if (clientManagement != null) {
            ClientResponse clientResponse = new ClientResponse(
                    clientManagement.getId(),
                    clientManagement.getName(),
                    clientManagement.getLastName(),
                    clientManagement.getMobile(),
                    clientManagement.getEmail(),
                    clientManagement.getAddress()
            );

            return ResponseEntity.ok(clientResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> deleteClient(Long id) {
        Optional<ClientManagement> optionalClientManagement = clientManagementRepository.findById(id);
        if (optionalClientManagement.isPresent()) {
            clientManagementRepository.deleteById(id);
            return ResponseEntity.ok("Client  : " + id + " Deleted Successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
