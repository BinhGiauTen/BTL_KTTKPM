package com.example.NotificationService.controllers;

import com.example.NotificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService rateLimitService;

    @GetMapping("/notify")
    public ResponseEntity<String> notifyUser() {
        if (!rateLimitService.tryAcquire()) {
            return ResponseEntity.badRequest().body("Rate limit exceeded"); // 429 Too Many Requests
        }
        return ResponseEntity.ok("Notification sent!");
    }
}
