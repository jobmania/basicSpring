package com.demo.controller;

import com.demo.beans.DataBean;
import com.demo.beans.UserDataBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
public class TestController {

    @GetMapping("/test1")
    public String test1(UserDataBean bean) {

        bean.setUser_name("홍길동");
        bean.setUser_id("abcd");
        bean.setUser_pw("1234");
        bean.setUser_postcode("12345");
        bean.setUser_address1("주소1번입니다");
        bean.setUser_address2("주소 2번입니다");

        return "test1";
    }

    @GetMapping("/test2")
    public String test2(@ModelAttribute UserDataBean bean) {
        bean.setUser_name("홍길동");
        bean.setUser_id("abcd");
        bean.setUser_pw("1234");
        bean.setUser_postcode("12345");
        bean.setUser_address1("주소1번입니다");
        bean.setUser_address2("주소 2번입니다");

        return "test2";
    }

    @GetMapping("/test3")
    public String test1(DataBean bean) {

        bean.setA1("select2"); //select

        String[] check_list = { "check1", "check3" }; //check box
        bean.setA2(check_list);

        bean.setA3("radio2"); //radio

        return "test3";
    }

    @PostMapping("/result")
    public String result(DataBean bean){
        System.out.println(bean.getA1());
        System.out.println(Arrays.toString(bean.getA2()));
        System.out.println(bean.getA3());
        return "result";
    }

}
