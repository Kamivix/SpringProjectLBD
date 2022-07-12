package com.example.springprojectlbd.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ServiceAspect {

    private final Logger LOG = LoggerFactory.getLogger(ServiceAspect.class);

    @Around("execution(* com.example.springprojectlbd.services.SprintService(..))")
    public void before(JoinPoint joinPoint) {
        LOG.info("ServiceAspect Before (params):");
        for (Object obj : joinPoint.getArgs())
            LOG.info("\t{}", obj.toString());
    }

    @AfterReturning(pointcut = "execution(* com.example.springprojectlbd.services.SprintService(..))", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        LOG.info("ServiceAspect After (result):");
        if (result != null)
            LOG.info("\t{}", result.toString());
    }

}
