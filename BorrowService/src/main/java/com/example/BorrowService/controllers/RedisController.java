package com.example.BorrowService.controllers;

import com.example.BorrowService.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/add")
    public String addToRedis(@RequestParam String key, @RequestParam String value) {
        redisService.addDataToRedis(key, value);
        return "Data added to Redis";
    }
}
