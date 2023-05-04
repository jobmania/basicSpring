package com.demo.controller;

import com.demo.model.Dto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/test1")
    public String test1(HttpServletRequest request) {
        String data1 = request.getParameter("data1");
        String data2 = request.getParameter("data2");

        System.out.println("data1 = " + data1);
        System.out.println("data2 = " + data2);

        return "result";
    }

    @PostMapping("/test2")
    public String test2(HttpServletRequest request) {
        String data1 = request.getParameter("data1");
        String data2 = request.getParameter("data2");
        String[] data3 = request.getParameterValues("data3");

        System.out.println("data1 : " + data1);
        System.out.println("data2 : " + data2);

        if (data3 != null) {
            for (String str1 : data3) {
                System.out.println("data3 : " + str1);
            }
        }
        return "result";
    }

	@GetMapping("/test3/{data1}/{data2}/{data3}")
	public String test4(@PathVariable int data1,
						@PathVariable int data2,
						@PathVariable int data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);

		int add = data1 + data2 + data3;
		System.out.println("add : " + add);

		return "result";
	}


	@GetMapping("/test4")
	public String test4(@RequestParam int data1,
						@RequestParam(defaultValue = "100") int data2,
						@RequestParam(required = false) int [] data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		for(int a1 : data3) {
			System.out.println("data3 : " + a1);
		}

		return "result";
	}

    @GetMapping("/test5")
    public String test5(@RequestParam Map<String, String> map) {
        String data1 = map.get("data1");
        String data2 = map.get("data2");
        String data3 = map.get("data3");

        System.out.printf("data1 : %s\n", data1);
        System.out.printf("data2 : %s\n", data2);
        System.out.printf("data3 : %s\n", data3);

        return "result";
    }


    @GetMapping("/test6")
    public String test6(@ModelAttribute Dto dto) {
        System.out.printf("data1 : %d\n", dto.getData1());
        System.out.printf("data2 : %d\n", dto.getData2());

        for(int number1 : dto.getData3()) {
            System.out.printf("data3 : %d\n", number1);
        }

        return "result";
    }

}
