package com.demo.config;


import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 빈등록
@ComponentScan(basePackages = "com.demo.beans") // 컴포넌트 스캔
public class BeanConfigClass {

    @Bean  // 메소드를 이용한 빈등록.
    public TestBean1 testBean1(){
        return new TestBean1();
    }

    @Bean
    public TestBean2 testBean2(){
        return new TestBean2();
    }

}
