package com.demo.main;

import com.demo.beans.TestBean;
import com.demo.beans.TestBean2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {


	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		TestBean bean1 = ctx.getBean("xml1", TestBean.class);
		int a1 = bean1.method1();
		System.out.println("a1 = " + a1); // 마지막에 생성..

		TestBean2 bean2 = ctx.getBean("xml2", TestBean2.class);
		bean2.method1(10);

		ctx.close();
	}

}
