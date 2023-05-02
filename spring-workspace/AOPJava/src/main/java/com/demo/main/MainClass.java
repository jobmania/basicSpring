package com.demo.main;

import com.demo.beans.TestBean1;
import com.demo.config.BeanConfigClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        // xml 빈 설정
        ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("beans.xml");

        TestBean1 xml1 = ctx1.getBean(TestBean1.class);

        xml1.method1();

        ctx1.close();

        System.out.println("========================================");
        // 자바 빈 설정
        AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfigClass.class);

        TestBean1 java1 = ctx2.getBean(TestBean1.class);

        java1.method1();

        ctx2.close();
    }


}
