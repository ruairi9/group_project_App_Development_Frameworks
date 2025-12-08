package org.example.group_project;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspects {

    private static final Logger log = LoggerFactory.getLogger(Aspects.class);

    @Pointcut("execution(* org.example.group_project.services..*(..))")
    public void allServiceMethods() {}

    @Pointcut("execution(* org.example.group_project.controllers..*(..))")
    public void allControllerMethods() {}

    @Pointcut("execution(* org.example.group_project.services.PlanetService.find*(..))")
    public void planetFindMethods() {}

    @Before("allServiceMethods()")
    public void logServiceCall(JoinPoint jp) {
        log.info("Service call: {}.{}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName());
    }

    @Before("allControllerMethods()")
    public void logControllerCall(JoinPoint jp) {
        log.info("Controller call: {}.{}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName());
    }

    @Before("planetFindMethods()")
    public void logPlanetFind(JoinPoint jp) {
        log.info("PlanetService find*: {}.{}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName());
    }
}
