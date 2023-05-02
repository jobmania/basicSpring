package com.demo.config;


import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans.TestBean3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration // 빈등록
public class BeanConfigClass {

    @Bean(initMethod = "init", destroyMethod = "destroy") // 메소드명입력
    public TestBean1 java1(){ // 메소드 이름이 이름이됨
        TestBean1 tq = new TestBean1();
        return tq;
    }

    @Bean(name = "java600") // 객체명 이름 저장.
    public TestBean1 java(){
        return new TestBean1();
    }

    @Bean
    @Lazy // 이 객체를 불러올때 getBean메소드 사용할 때 생성.
    public TestBean2 java2(){
        return new TestBean2();
    }


    @Bean
    @Scope("prototype") // 프로토 타입을 설정 -> 불러올 때마다 새로운 객체 생성(싱글톤 x)
    public TestBean3 java3(){
        return new TestBean3();
    }

}
