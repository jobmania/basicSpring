package com.demo.controller;

import com.demo.beans.Product;
import com.demo.beans.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TestController {


    @GetMapping("/input_product")
    public String input_product(Product product) {	//Product 빈 객체를 request 로 보냄
        return "input_product";
    }

    @PostMapping("/input_product_proc")
    public String input_product(@Valid Product product, BindingResult result) {


        if(result.hasErrors()) {
            return "input_product";
        }

        System.out.println(product.toString());

        return "input_product_success";
    }
}
