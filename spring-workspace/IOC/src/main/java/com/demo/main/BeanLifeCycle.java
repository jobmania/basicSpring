package com.demo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.demo.beans.TestBean1;


public class BeanLifeCycle {
	
	//로그 객체 선언(사용시 사용하는 클래스의 이름을 괄호안에 입력)
	private static final Logger log = LoggerFactory.getLogger(BeanLifeCycle.class);

	public static void main(String[] args) {
		log.info("시작");
		// beans.xml 파일을 로딩한다.
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("config/beanLifeCycle.xml");
		//xml에 정의된 bean 객체를 가져오기
		TestBean1 t1 = ctx.getBean("t1", TestBean1.class);
		System.out.printf("t1 : %s\n", t1);

		ctx.close(); // 컨테이너 닫기
		
		log.info("끝");
	}

}
