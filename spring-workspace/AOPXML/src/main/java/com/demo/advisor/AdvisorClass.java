package com.demo.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdvisorClass {
    public void beforeMethod(){
        System.out.println("before");
    }

    public void afterMethod(){
        System.out.println("after");
    }

    // 이전, 이후를 다 포함하여 실제 메소드를 메소드 안에서 실행.
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aroundMethod 호출1");
        Object obj = pjp.proceed();
        System.out.println("aroundMethod 호출2");

        return obj;
    }
}
