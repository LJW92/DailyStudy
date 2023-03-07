package com.jiawei.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect //标注切面类
public class AnnotationPointCut {
    @Before("execution(* com.jiawei.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("before annotationpointcut");
    }

    @After("execution(* com.jiawei.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("after annotationpointcut");
    }

    @Around("execution(* com.jiawei.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        Signature signature = jp.getSignature();
        System.out.println(signature);
        Object proceed = jp.proceed();//必写，否则不执行Before和after
        System.out.println("环绕后");
       System.out.println(proceed);
    }
}
