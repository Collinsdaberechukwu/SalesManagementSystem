package com.example.salesmanagementsystem.service.implementation;

import com.example.salesmanagementsystem.dto.request.LogCreationRequest;
import com.example.salesmanagementsystem.dto.request.LogUpdateRequest;
import com.example.salesmanagementsystem.dto.response.LogCreationResponse;
import com.example.salesmanagementsystem.dto.response.LogResponse;
import com.example.salesmanagementsystem.dto.response.LogUpdateResponse;
import com.example.salesmanagementsystem.enums.LogActionType;
import com.example.salesmanagementsystem.model.Log;
import com.example.salesmanagementsystem.repository.LogRepository;
import com.example.salesmanagementsystem.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Override
    public ResponseEntity<LogCreationResponse> createLog(LogCreationRequest logCreationRequest){
        Log newLog = Log.builder().build();

        newLog.setName(logCreationRequest.getName());
        newLog.setLogActionType(LogActionType.valueOf(String.valueOf(logCreationRequest.getLogActionType()).toUpperCase()));

        Log savedLog = logRepository.save(newLog);

        LogCreationResponse response = new LogCreationResponse(savedLog.getId(), "Log created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<LogUpdateResponse> updateLog(Long logId, LogUpdateRequest logUpdateRequest) {
        Optional<Log> optionalLog = logRepository.findById(logId);

        if (optionalLog.isPresent()) {
            Log existingLog = optionalLog.get();
            existingLog.setName(logUpdateRequest.getName());
            existingLog.setLogActionType(LogActionType.valueOf(String.valueOf(logUpdateRequest.getLogActionType()).toUpperCase()));

            Log updatedLog = logRepository.save(existingLog);

            LogUpdateResponse response = new LogUpdateResponse(updatedLog.getId(), "Log updated successfully");

            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<LogResponse> getLog(Long logId) {
        Optional<Log> optionalLog = logRepository.findById(logId);

        return optionalLog.map(log -> {
            LogResponse logResponse = new LogResponse();
            logResponse.setId(log.getId());
            logResponse.setName(log.getName());
            logResponse.setLogActionType(log.getLogActionType());
            return ResponseEntity.ok().body(logResponse);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<String> deleteLog(Long logId) {
        Optional<Log> optionalLog = logRepository.findById(logId);

        if (optionalLog.isPresent()) {
            logRepository.deleteById(logId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
