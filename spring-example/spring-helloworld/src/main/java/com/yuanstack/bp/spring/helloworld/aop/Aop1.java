package com.yuanstack.bp.spring.helloworld.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:12
 */
public class Aop1 {

    //前置通知
    public void startTransaction() {
        System.out.println("    ====>begin ding... "); //2
    }

    //后置通知
    public void commitTransaction() {
        System.out.println("    ====>finish ding... "); //4
    }

    //环绕通知
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("    ====>around begin ding"); //1
        //调用process()方法才会真正的执行实际被代理的方法
        joinPoint.proceed();

        System.out.println("    ====>around finish ding"); //3
    }

}
