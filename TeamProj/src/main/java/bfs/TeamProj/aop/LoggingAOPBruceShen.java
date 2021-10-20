package bfs.TeamProj.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Component
@Aspect
public class LoggingAOPBruceShen {
    Logger log = LoggerFactory.getLogger(this.getClass());
/*
    @Pointcut("within(bfs.TeamProj.dao.hibernate.*)")
    public void inDaoLayer() {}

    @Around("bfs.TeamProj.aop.LoggingAOPBruceShen.inDaoLayer()")
    public Object executionTimeAdvice1(ProceedingJoinPoint pjp) throws Throwable{
        String signature = pjp.getSignature().toString();
        //Object[] parameters = pjp.getArgs();
        Object clazz = pjp.getSignature().getDeclaringType();

        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;

        log.info("Using \"within(bfs.TeamProj.dao.hibernate.*)\"");
        log.info("class: "+clazz);
        log.info(signature+ " execution time: "+elapsedTime+" ms");
        //log.info("return value: "+result.toString());
        return result;
    }
*/

    /*
    @Pointcut("execution(* bfs.TeamProj.dao.RoleDao.*(..))")
    public void inRoleDao() {}

        @Around("bfs.TeamProj.aop.LoggingAOPBruceShen.inRoleDao()")
        public Object executionTimeAdvice2(ProceedingJoinPoint pjp) throws Throwable{
            String signature = pjp.getSignature().toString();
            //Object[] parameters = pjp.getArgs();
            Object clazz = pjp.getSignature().getDeclaringType();

            long startTime = System.currentTimeMillis();
            Object result = pjp.proceed();
            long elapsedTime = System.currentTimeMillis() - startTime;

            log.info("Using \"execution(* bfs.TeamProj.dao.RoleDao.*(..))\"");
            log.info("class: "+clazz);
            log.info(signature+ " execution time: "+elapsedTime+" ms");

            return result;

        }
     */

    /*
    @Around(value = "target(bfs.TeamProj.dao.RegistrationTokenDao)")
    public Object executionTimeAdvice3(ProceedingJoinPoint pjp) throws Throwable {
        String signature = pjp.getSignature().toString();
        //Object[] parameters = pjp.getArgs();
        Object clazz = pjp.getSignature().getDeclaringType();

        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;

        log.info("Using \"target(bfs.TeamProj.dao.RegistrationTokenDao)\"");
        log.info("class: " + clazz);
        log.info(signature + " execution time: " + elapsedTime + " ms");

        return result;

    }

    @Around(value = "bean(hibernateAddressDao)")
    public Object executionTimeAdvice4(ProceedingJoinPoint pjp) throws Throwable {
        String signature = pjp.getSignature().toString();
        //Object[] parameters = pjp.getArgs();
        Object clazz = pjp.getSignature().getDeclaringType();

        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;

        log.info("Using \"bean(HibernateAddressDao)\"");
        log.info("class: " + clazz);
        log.info(signature + " execution time: " + elapsedTime + " ms");

        return result;

    }*/

    @Before("within(bfs.TeamProj.controller.*) && args(request,..)")
    public void beforeAdvice(JoinPoint joinPoint, HttpServletRequest request) {
        log.info("Web Layer Before Advice");
        log.info("" + joinPoint.getSignature());
        log.info("Class: " + joinPoint.getSignature().getName());
        log.info("Method: " + joinPoint.getSignature().getDeclaringTypeName());
        log.info("arguments: " + Arrays.toString(joinPoint.getArgs()));
        //log.info("obj: " + String.valueOf(obj));

        if (null != request) {
            log.info("Start Header Section of request ");
            log.info("Method Type : " + request.getMethod());
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = (String) headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                //log.info("Header Name: " + headerName + " Header Value : " + headerValue);
                log.info(headerName + " " + headerValue);
            }
            log.info("Request Path info :" + request.getServletPath());
        }


    }
    @Before("within(bfs.TeamProj.controller.*) && args(obj)")
    public void beforeAdvice2(JoinPoint joinPoint, Object obj) {
        log.info("Web Layer Before Advice");
        log.info("" + joinPoint.getSignature());
        log.info("Class: " + joinPoint.getSignature().getName());
        log.info("Method: " + joinPoint.getSignature().getDeclaringTypeName());
        log.info("arguments: " + Arrays.toString(joinPoint.getArgs()));
        //log.info("obj: " + String.valueOf(obj));
/*
        if (null != request) {
            log.info("Start Header Section of request ");
            log.info("Method Type : " + request.getMethod());
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = (String) headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                //log.info("Header Name: " + headerName + " Header Value : " + headerValue);
                log.info(headerName + " " + headerValue);
            }
            log.info("Request Path info :" + request.getServletPath());
        }*/


    }

    @AfterReturning(value = "within(bfs.TeamProj.controller.*)", returning = "res")
    public void afterReturningAdvice(Object res) {
        log.info("Web Layer After Returning Advice ");
        log.info("The return value is: " + res.toString());
    }


}
