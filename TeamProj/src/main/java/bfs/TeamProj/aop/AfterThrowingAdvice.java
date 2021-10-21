package bfs.TeamProj.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AfterThrowingAdvice {

    @AfterThrowing(pointcut = "execution(* bfs.TeamProj.Service.UserService.*(..))",throwing = "ex")
    public void afterThrowingAdvice(Exception ex){
        System.out.println("Exception is: "+ex.getMessage());
    }
}
