package com.example.salesmanagementsystem.service;

import com.example.salesmanagementsystem.dto.request.LogCreationRequest;
import com.example.salesmanagementsystem.dto.request.LogUpdateRequest;
import com.example.salesmanagementsystem.dto.response.LogCreationResponse;
import com.example.salesmanagementsystem.dto.response.LogResponse;
import com.example.salesmanagementsystem.dto.response.LogUpdateResponse;
import org.springframework.http.ResponseEntity;

public interface LogService {
    ResponseEntity<LogCreationResponse> createLog(LogCreationRequest logCreationRequest);

    ResponseEntity<LogUpdateResponse> updateLog(Long logId, LogUpdateRequest logUpdateRequest);

    ResponseEntity<LogResponse> getLog(Long logId);

    ResponseEntity<String> deleteLog(Long logId);
}
