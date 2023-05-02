package com.demo.advisor;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect//
@Component
public class AdvisorClass {
    @Before("execution(* method1())")
    public void beforeMethod(){
        System.out.println("before");
    }
    @After("execution(* method1())")
    public void afterMethod(){
        System.out.println("after");
    }
}
