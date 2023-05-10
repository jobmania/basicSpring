package com.demo.controller;

import com.demo.beans.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean")UserBean joinUserBean) {
		return "user/join";
	}

	@PostMapping("/join_pro")
	// @Valid를 붙여주면 유효성 검증이 진행된다.
	//  에러시 에러메세지와 다시 원래 페이지로 되돌아감
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "user/join";
		}

		if(!joinUserBean.getUser_pw().equals(joinUserBean.getUser_pw2())) {

			model.addAttribute("msg", "비밀번호가 같지 않습니다!");
			return "user/join";
		}

		return "user/join_success";
	}


	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "user/logout";
	}
}
