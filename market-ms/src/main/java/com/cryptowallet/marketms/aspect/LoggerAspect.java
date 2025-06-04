package com.cryptowallet.marketms.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggerAspect {
    @Around("execution(* com.cryptowallet.marketms.service.*.*(..))")
    public Object logServiceMethods(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        log.info("Executing {}.{} with arguments {}", className, methodName, joinPoint.getArgs());

        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;

            log.info("{}.{} returned {} in {}ms", className, methodName, result, duration);
            return result;
        } catch (Throwable throwable) {
            log.error("Exception in {}.{}: {}", className, methodName, throwable.getMessage(), throwable);
            throw throwable;
        }
    }
}