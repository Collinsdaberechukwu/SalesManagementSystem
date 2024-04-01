package com.example.salesmanagementsystem.controller;

import com.example.salesmanagementsystem.dto.request.LogCreationRequest;
import com.example.salesmanagementsystem.dto.request.LogUpdateRequest;
import com.example.salesmanagementsystem.dto.response.LogCreationResponse;
import com.example.salesmanagementsystem.dto.response.LogResponse;
import com.example.salesmanagementsystem.dto.response.LogUpdateResponse;
import com.example.salesmanagementsystem.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/log-management")
public class LogController {

    private final LogService logService;

    @PostMapping("/create-log")
    public ResponseEntity<LogCreationResponse> createLog(@RequestBody LogCreationRequest logCreationRequest) {
        return logService.createLog(logCreationRequest);
    }

    @PutMapping("/update-log/{logId}")
    public ResponseEntity<LogUpdateResponse> updateLog(@PathVariable Long logId, @RequestBody LogUpdateRequest logUpdateRequest) {
        return logService.updateLog(logId, logUpdateRequest);
    }

    @GetMapping("/achieve-log/{logId}")
    public ResponseEntity<LogResponse> getLog(@PathVariable Long logId) {
        return logService.getLog(logId);
    }

    @DeleteMapping("/delete/{logId}")
    public ResponseEntity<String> deleteLog(@PathVariable Long logId) {
        return logService.deleteLog(logId);
    }
}
