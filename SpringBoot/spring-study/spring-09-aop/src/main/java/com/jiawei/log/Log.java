package com.jiawei.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Log implements MethodBeforeAdvice {

    //method:要执行的目标对象的方法
    //objects： 参数
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+ "的" + method.getName() + "被执行了");
    }
}
