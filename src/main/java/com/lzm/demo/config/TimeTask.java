package com.lzm.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lizhiming
 * @data 2020/8/10 11:16
 */
@Slf4j
@Component
public class TimeTask {

    private int[] people = {9000,2000,3000,1000};

    private int count = 0;

    @Scheduled(fixedDelay = 5000)
    public void fixedDelayTask() throws InterruptedException {
        if (count < 4) {
            int timeConsuming = people[count];
            log.info("fixedDelayTask-----第 {} 个人开始如厕，耗时：{}ms",count+1, timeConsuming);
            Thread.sleep(timeConsuming);
            count++;
        }
    }

//    @Scheduled(cron = "0/5 * * * * ? ")
//    public void cronTask() throws InterruptedException {
//        if (count < 4) {
//            int timeConsuming = people[count];
//            log.info("cronTask-----第 {} 个人开始如厕，耗时：{}ms",count+1, timeConsuming);
//            Thread.sleep(timeConsuming);
//            count++;
//        }
//    }
//
//    @Scheduled(fixedRate = 5000)
//    public void fixedRateTask() throws InterruptedException {
//        if (count < 4) {
//            int timeConsuming = people[count];
//            log.info("fixedRateTask-----第 {} 个人开始如厕，耗时：{}ms",count+1, timeConsuming);
//            Thread.sleep(timeConsuming);
//            count++;
//        }
//    }

}
