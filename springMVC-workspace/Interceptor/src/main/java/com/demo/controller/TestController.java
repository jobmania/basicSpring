package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test1")
    public String test1() {
        System.out.println("test 1 request");
        return "test1";
    }

    @GetMapping("/test2")
    public String test2() {
        return "test2";
    }



}
