package demo.main;

import demo.beans.HelloWorld;
import demo.beans.HelloWorldEn;
import demo.beans.HelloWorldKo;

public class MainClass {

	public static void main(String[] args) {
		
		//HelloWorldEn h1 = new HelloWorldEn();
		HelloWorld h1 = new HelloWorldKo();
		callMethod(h1);
		
		HelloWorld h2 = new HelloWorldEn();
		callMethod(h2);

	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}

}
