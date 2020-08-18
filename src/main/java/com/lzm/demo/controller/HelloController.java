package com.lzm.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author lizhiming
 * @data 2020/7/20 17:24
 */
@Api
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @ApiOperation("Hello Spring Boot 方法")
    @GetMapping("/")
    public String hello(String name) {

        redisTemplate.opsForValue().set("hello","world");
        // 获取 Redis 中 key 为 hello 的值
        System.out.println(redisTemplate.opsForValue().get("hello"));
        if (name == null || "".equals(name)) {
            name = "Spring Boot";
        }
        log.info("hello");
        return "Hello "+name;
    }
}