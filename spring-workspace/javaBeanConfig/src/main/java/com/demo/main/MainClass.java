package com.demo.main;

import com.demo.beans.TestBean1;
import com.demo.config.BeanConfigClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	// 로그 객체 선언(사용시 사용하는 클래스의 이름을 괄호안에 입력)
	private static final Logger log = LoggerFactory.getLogger(MainClass.class);

	public static void main(String[] args) {
		log.info("시작");
		// beans.xml 파일을 로딩한다.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);




		ctx.close();
		log.info("끝");
	}

}
