package de.atruvia.webapp.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile("production")
@Aspect
@Slf4j
public class LoggerAspects {



    @Before("PointCuts.controllerMethods()")
    public void logAdvice(JoinPoint joinPoint) {
        log.warn("############################# Before: "+ joinPoint.getSignature().getName() + " ######################");
    }

    @Before("PointCuts.dozentMethods()")
    public void yepp(JoinPoint joinPoint) {
        log.warn("############################# Before: Dozent sagt des gehoert so ######################");
    }


    @AfterReturning(value ="PointCuts.personenQueryControllerMethods()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.warn("############################# "+ joinPoint.getSignature().getName() + " ######################");
        System.out.println(result);
    }

    @AfterThrowing(value ="execution(public * de.atruvia.webapp.presentation.controller.version1.PersonenQueryController.*(..))", throwing = "ex")
    public void afterReturning(JoinPoint joinPoint, Throwable ex) {
        log.warn("############################# "+ joinPoint.getSignature().getName() + " ######################");
        System.out.println(ex.getMessage());
    }

    @After(value ="execution(public * de.atruvia.webapp.presentation.controller.version1.PersonenQueryController.*(..))")
    public void after(JoinPoint joinPoint) {
        log.warn("############################# After: "+ joinPoint.getSignature().getName() + " ######################");

    }

    @Around(value ="execution(public * de.atruvia.webapp.presentation.controller.version1.PersonenQueryController.*(..))")
    public Object after(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.warn("############################# After: "+ proceedingJoinPoint.getSignature().getName() + " ######################");

        var result = proceedingJoinPoint.proceed();
        return result;
    }
}
