package com.demo.config;


import com.demo.beans.*;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration // 빈등록
public class BeanConfigClass {

    //java1 등록
    @Bean
    public TestBean1 java1() {
        return new TestBean1();
    }

    //DataBean1 타입 data_bean1 등록
    @Bean
    public DataBean1 data_bean1() {
        return new DataBean1();
    }

    //DataBean2 obj4와 ojb5 등록
    @Bean
    public DataBean2 obj4() {
        return new DataBean2();
    }

    @Bean
    public DataBean2 obj5() {
        return new DataBean2();
    }


    @Bean
    @Lazy
    public TestBean2 testBean2(){
      return new TestBean2();
    }


    @Bean
    public TestBean3 testBean3() {
        return new TestBean3();
    }


    @Bean
    public DataBean2 data2() {
        return new DataBean2();
    }

    @Bean
    public DataBean2 data3() {
        return new DataBean2();
    }


}
