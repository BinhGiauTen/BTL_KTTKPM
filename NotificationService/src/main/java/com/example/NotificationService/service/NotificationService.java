package com.example.NotificationService.service;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private RateLimiter rateLimiter = RateLimiter.create(0.08330); // Giới hạn 5 yêu cầu mỗi 60 giây : 5/60 = 0.08330

    public boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }
}
