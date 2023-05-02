package com.demo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.HelloWorld;


public class MainClass {
	
	//로그 객체 선언(사용시 사용하는 클래스의 이름을 괄호안에 입력)
	private static final Logger log = LoggerFactory.getLogger(MainClass.class);

	public static void main(String[] args) {
		log.info("시작");
		// beans.xml 파일을 로딩한다.
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("config/beans.xml");
		//xml에 정의된 bean 객체를 가져오기
		HelloWorld h1 = (HelloWorld) ctx.getBean("hello");
		callMethod(h1);
		HelloWorld h2 = ctx.getBean("hello", HelloWorld.class);
		callMethod(h2);
		
		ctx.close(); // 컨테이너 닫기
		
		log.info("끝");
	}
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}


}
