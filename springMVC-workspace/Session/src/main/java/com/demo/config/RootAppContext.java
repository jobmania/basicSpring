package com.demo.config;

import com.demo.beans.DataBean1;
import com.demo.beans.DataBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

//프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
@ComponentScan("com.demo.beans")
public class RootAppContext {

    // 등록 객체는 새로운 요청시 새 객채를 생성.
    @Bean
    @RequestScope
    public DataBean1 bean1(){
        return new DataBean1();
    }


    @Bean
    @RequestScope
    public DataBean2 bean2(){
        return new DataBean2();
    }

}
