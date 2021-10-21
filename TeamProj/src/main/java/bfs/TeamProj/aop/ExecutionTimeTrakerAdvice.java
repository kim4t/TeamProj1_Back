package bfs.TeamProj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrakerAdvice {

    Logger logger = LoggerFactory.getLogger(ExecutionTimeTrakerAdvice.class);

    @Around("@annotation(bfs.TeamProj.aop.TrackExecutionTime)")
    public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Method name: "+pjp.getSignature()+" time taken to execute: "+ (endTime-startTime));
        return obj;
    }
}
