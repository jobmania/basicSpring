package com.demo.controller;

import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    private final UserService userService;

    public RestApiController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/user/check/{user_id}")
    public String checkUserIdExist(@PathVariable String user_id){
        boolean result = userService.checkUserIdExist(user_id);
        return String.valueOf(result);
        // restController는 data를 body에 넣어서 return.. 따로 view로 가지 않음.
    }
}
