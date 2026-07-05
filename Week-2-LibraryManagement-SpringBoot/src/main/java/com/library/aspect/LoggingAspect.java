package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore() {
        System.out.println("🔵 [BEFORE] Method execution started");
    }

    @After("execution(* com.library.service.*.*(..))")
    public void logAfter() {
        System.out.println("🟢 [AFTER] Method execution completed");
    }

    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("⏱️ Starting: " + methodName + "()");
        Instant start = Instant.now();
        Object result = joinPoint.proceed();
        Instant finish = Instant.now();
        long timeMillis = Duration.between(start, finish).toMillis();
        System.out.println("⏱️ Completed: " + methodName + "() - " + timeMillis + "ms");
        return result;
    }
}