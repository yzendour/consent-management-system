package com.consent.consentmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/consent")
public class ConsentController {

    private final DataProcessingService service;

    @Autowired
    public ConsentController(DataProcessingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> process(@RequestParam String userId, @RequestParam boolean hasConsented) {
        service.processUserData(userId, hasConsented);
        return ResponseEntity.ok("Processed user: " + userId);
    }
}
