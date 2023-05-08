package com.demo.controller;

import com.demo.beans.DataBean;
import com.demo.beans.DataBean1;
import com.demo.beans.DataBean2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @Autowired
    DataBean1 bean1;

    @Autowired
    DataBean2 bean2;


    @GetMapping("/test1")
    public String test1(HttpServletRequest request) {
        request.setAttribute("data1", "um");
        // forward요청 => request
        return "forward:/result1";
    }

    @GetMapping("/result1")
    public String result1(HttpServletRequest request) {
        String data1 = (String)request.getAttribute("data1");
        System.out.printf("data1 : %s\n", data1);

        return "result1";
    }



    @GetMapping("/test2")
    public String test2(Model model) {
        //모델을 통해 저장한 데이터는 리퀘스트에 저장된다.
        model.addAttribute("data2", "um2");

        return "forward:/result2";
//        return "redirect:/result2";
    }

    @GetMapping("/result2")
    public String result2(Model model, HttpServletRequest request) {

        String data2 = (String)model.getAttribute("data2"); // forward시 model x, request로
        System.out.printf("data2 : %s\n", data2);
        String data22 = (String) request.getAttribute("data2");
        System.out.println("data22 = " + data22);

        return "result2";
    }


    @GetMapping("/test3")
    public ModelAndView test3(ModelAndView mv) {

        mv.addObject("data3", "um3");
        mv.setViewName("forward:/result3");

        return mv;
    }

    @GetMapping("/result3")
    public String result3(HttpServletRequest request) {
        String data3 = (String)request.getAttribute("data3");
        System.out.printf("data3 : %s\n", data3);

        return "result3";
    }

    @GetMapping("/test4")
    public String test4(Model model) {
        DataBean bean1 = new DataBean();
        bean1.setData1("um4");
        bean1.setData2("um5");

        model.addAttribute("bean1", bean1);

        return "forward:/result4";
    }

    @GetMapping("/result4")
    public String result4(HttpServletRequest request) {

        DataBean bean1 = (DataBean)request.getAttribute("bean1");
        System.out.printf("bean1.data1 : %s\n", bean1.getData1());
        System.out.printf("bean1.data2 : %s\n", bean1.getData2());

        return "result4";
    }


    @GetMapping("/beanTest")
    public String test1(){

        bean1.setData1("UM1");
        bean1.setData2("UM2");

        bean2.setData1("UM3");
        bean2.setData2("UM4");

        return "forward:/beanResult";
    }

    @GetMapping("/beanResult")
    public String result1(Model model) {

        System.out.printf("requestBean1.data1 : %s\n", bean1.getData1());
        System.out.printf("requestBean1.data2 : %s\n", bean1.getData2());

        System.out.printf("requestBean2.data3 : %s\n", bean2.getData1());
        System.out.printf("requestBean2.data4 : %s\n", bean2.getData2());


        model.addAttribute("bean1", bean1);
        model.addAttribute("bean2", bean2);

        return "beanResult";
    }


}
