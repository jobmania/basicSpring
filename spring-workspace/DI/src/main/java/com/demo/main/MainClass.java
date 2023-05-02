package com.demo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean;
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
		obj1.printData();

		System.out.println("-------------------------------");

		TestBean1 obj2 = ctx.getBean("obj2", TestBean1.class);
		obj2.printData();

		System.out.println("-------------------------------");

		TestBean1 obj3 = ctx.getBean("obj3", TestBean1.class);
		obj3.printData();

		System.out.println("-------------------------------");

		TestBean2 obj4 = ctx.getBean("obj4", TestBean2.class);
		obj4.printData();

		System.out.println("-------------------------------");

		TestBean2 obj5 = ctx.getBean("obj5", TestBean2.class);
		obj5.printData();
		
		System.out.println("-------------------------------");
		
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t1.data1 : %d\n", t1.getData1());
		System.out.printf("t1.data2 : %f\n", t1.getData2());
		System.out.printf("t1.data3 : %s\n", t1.isData3());
		System.out.printf("t1.data4 : %s\n", t1.getData4());
		System.out.printf("t1.data5 : %s\n", t1.getData5());
		System.out.printf("t1.data6 : %s\n", t1.getData6());


		ctx.close(); // 컨테이너 닫기

		log.info("끝");
	}

}
