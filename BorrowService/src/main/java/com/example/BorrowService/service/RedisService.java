//package com.example.BorrowService.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RedisService {
//
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
//    public void addDataToRedis(String key, String value) {
//        redisTemplate.opsForValue().set(key, value);
//    }
//}
