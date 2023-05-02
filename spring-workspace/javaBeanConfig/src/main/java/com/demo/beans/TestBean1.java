package com.demo.beans;

import javax.swing.plaf.PanelUI;

public class TestBean1 {


    

    public TestBean1(){
        System.out.println("TestBean1 생성자");
    }

    public void init(){
        System.out.println("TestBean1 객체 생성시 실행됨!");
    }

    public void destroy(){
        System.out.println("TestBean1 객체 소멸");
    }

}
