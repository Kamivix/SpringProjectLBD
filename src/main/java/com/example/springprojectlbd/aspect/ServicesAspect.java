package com.example.springprojectlbd.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class ServicesAspect {
    private static final Logger logger = LoggerFactory.getLogger(ServicesAspect.class);
@Around("execution(* com.example.springprojectlbd.services.UserStoryService.*(..))")
public Object aroundServices(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
  logger.info("ServiceAspect Before (params):");
    Object val=0;
  for (Object obj:proceedingJoinPoint.getArgs()){
            logger.info("\t{}", obj.toString());
            try {
                val=proceedingJoinPoint.proceed();
            }
            catch (Throwable e){

            }
            logger.info(val.toString() + " to zwraca");
        }
return val;
}
}
