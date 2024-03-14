package de.atruvia.webapp.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut(value="execution(public * de.atruvia.webapp.presentation.controller.version1.PersonenQueryController.*(..))")
    public void personenQueryControllerMethods(){}

    @Pointcut(value="within(de.atruvia.webapp.presentation.controller..*)")
    public void controllerMethods(){}


    @Pointcut("@within(de.atruvia.webapp.aspects.Dozent)")
    public void dozentMethods(){}
}
