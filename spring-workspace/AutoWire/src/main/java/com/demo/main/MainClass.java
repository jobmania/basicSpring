package com.demo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;

public class MainClass {

	// 로그 객체 선언(사용시 사용하는 클래스의 이름을 괄호안에 입력)
	private static final Logger log = LoggerFactory.getLogger(MainClass.class);

	public static void main(String[] args) {
		log.info("시작");
		// beans.xml 파일을 로딩한다.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");

		TestBean1 obj1 = ctx.getBean("obj1", TestBean1.class);
		System.out.printf("obj1.data1 : %s\n", obj1.getData1());
		System.out.printf("obj1.data2 : %s\n", obj1.getData2());
		
		System.out.println("-----------------------------------");
		
		TestBean1 obj2 = ctx.getBean("obj2", TestBean1.class);
		System.out.printf("obj2.data1 : %s\n", obj2.getData1());
		System.out.printf("obj2.data2 : %s\n", obj2.getData2());
				
		System.out.println("-----------------------------------");
		
		TestBean2 obj3 = ctx.getBean("obj3", TestBean2.class);
		System.out.printf("obj3.data1 : %s\n", obj3.getData1());
		System.out.printf("obj3.data2 : %s\n", obj3.getData2());
		
		System.out.println("-----------------------------------");
		
		TestBean2 obj4 = ctx.getBean("obj4", TestBean2.class);
		System.out.printf("obj4.data1 : %s\n", obj4.getData1());
		System.out.printf("obj4.data2 : %s\n", obj4.getData2());

		ctx.close(); // 컨테이너 닫기

		log.info("끝");
	}

}
