package com.example.springprojectlbd.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;


@Aspect
@Component
public class ServicesAspect {
    private static final Logger logger = LoggerFactory.getLogger(ServicesAspect.class);
@Around("execution(* com.example.springprojectlbd.services.*.*(*)) ")
public Object aroundServices(ProceedingJoinPoint proceedingJoinPoint) throws Throwable  {


    logger.info("ServiceAspect Before (params):"+ Arrays.toString(proceedingJoinPoint.getArgs()));
   Object val;

                val=proceedingJoinPoint.proceed();
                logger.info("Service's method return: " +val.toString());

return val;

            }




}
