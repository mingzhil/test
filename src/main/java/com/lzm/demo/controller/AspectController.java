package com.lzm.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizhiming
 * @data 2020/8/10 15:57
 */
@Slf4j
@RestController
@RequestMapping("/aspect")
public class AspectController {
    @GetMapping
    public String aspect(String message) {
        log.info("aspect controller");
        return message;
    }

    @GetMapping("/sleep/{time}")
    public String sleep(@PathVariable("time") long time) {
        log.info("sleep");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.error("error",e);
        }
        if (time == 1000) {
            throw new RuntimeException("runtime exception");
        }
        log.info("wake up");
        String wake_up= new String();
        return "你好";
    }
}
