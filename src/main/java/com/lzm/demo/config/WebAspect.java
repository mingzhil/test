package com.lzm.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhiming
 * @data 2020/8/10 15:57
 */
@Slf4j
@Aspect
@Component
public class WebAspect {

    @Pointcut("execution(public * com.lzm.demo.controller.*.*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Map<String, Object> paramMap = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }

        log.info("path：{}",request.getServletPath()  + new Date());
        log.info("class name：{}",className  + new Date());
        log.info("method name：{}",methodName  + new Date());
        log.info("args：{}",paramMap.toString()  + new Date());
    }

    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint) {
        log.info("{} after", joinPoint.getSignature().getName() + new Date());
    }

    @AfterReturning(value = "pointCut()", returning = "returnVal")
    public void afterReturning(JoinPoint  joinPoint, Object returnVal) {
        log.info("{} after return, returnVal: {}", joinPoint.getSignature().getName() + new Date(), returnVal);
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        log.info("execute time：{} ms",startTime);
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("around error",e);
        }
        long endTime = System.currentTimeMillis();
        log.info("execute time：{} ms",endTime);
        log.info("execute time：{} ms",endTime - startTime);
        return result;
    }
}