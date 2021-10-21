package bfs.TeamProj.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCuts {

    @Pointcut("execution(* bfs.TeamProj.aop..*.*(..))")
    public void inServiceLayer1() {}

    @Pointcut("bean(*Service)")
    public void inServiceLayer2(){}

    @Pointcut("within(bfs.TeamProj.aop..*)")
    public void inDataAccessLayer() {}

    @Pointcut("args()")
    public void noParameter(){}
}

