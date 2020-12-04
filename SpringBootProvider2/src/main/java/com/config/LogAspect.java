package com.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LogAspect {

    private static Logger logger = LoggerFactory.getLogger("LogAspect.class");
    @Pointcut("execution(* com.controller.HelloController.sayHello1(..))")
    public void logAspectPoint(){

    };

    @Before("logAspectPoint()")
    public void logAspectMonitorBefore(){


    }

    @After("logAspectPoint()")
    public void logAspectMonitorAfter(){


    };


    @Around("logAspectPoint()")
    public void logAspectMonitorAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {


        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String url1="requestUrl"+request.getRequestURL().toString();
        String url2="pathInfo"+request.getPathInfo();
        String url3="contextPath"+request.getContextPath();
        String url4="servletPath"+request.getServletPath();
        String url5="realPath"+request.getRealPath("");

        logger.info(url1);
        logger.info(url2);
        logger.info(url3);
        logger.info(url4);
        logger.info(url5);

        Thread.currentThread().getName();


        logger.info("执行切面方法之前");
        Object res=proceedingJoinPoint.proceed();//获取监控方法响应对象
        Object []args=proceedingJoinPoint.getArgs();//获取监控方法请求参数
        logger.info("执行切面方法之后");






    };


}
