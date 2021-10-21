package bfs.TeamProj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAOPBen {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("bfs.TeamProj.aop.PointCuts.inServiceLayer2() && bfs.TeamProj.aop.PointCuts.noParameter()")
    public void beforeServiceAdvice(JoinPoint joinPoint){
        log.info("Service Layer Before Advice ");
    }

    @After("bfs.TeamProj.aop.PointCuts.inServiceLayer2() && bfs.TeamProj.aop.PointCuts.noParameter()")
    public void afterServiceAdvice(JoinPoint joinPoint){
        log.info("Service Layer After Advice ");
    }
}
