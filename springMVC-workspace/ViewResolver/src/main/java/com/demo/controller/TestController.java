package com.demo.controller;

import com.demo.beans.DataBean;
import com.demo.model.Dto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/test1")
    public String test1() {
        // forward 요청으로 처리.. parameter 고대로 넘어감~
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(HttpServletRequest request) {

        request.setAttribute("data1", 100);
        request.setAttribute("data2", 200);

        return "test2";
    }


    @GetMapping("/test3")
    public String test3(Model model) {

        model.addAttribute("data1", 300);
        model.addAttribute("data2", 400);

        return "test3";
    }

    @GetMapping("/test4")
    public ModelAndView test4(ModelAndView mv) {

        mv.addObject("data1", 500);
        mv.addObject("data2", 600);

        mv.setViewName("test4");

        return mv;
    }


    @PostMapping("/test5")
    public String test5(@ModelAttribute DataBean bean) {
        // @ModelAttribute("test") 지정 가능, 없을 경우 클래스명의 첫글자가 소문자로 전환
        return "test5";
    }

}
