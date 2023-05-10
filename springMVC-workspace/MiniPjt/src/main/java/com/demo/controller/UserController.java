package com.demo.controller;

import com.demo.beans.LoginUserBean;
import com.demo.beans.UserBean;
import com.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	@Resource(name = "loginUserBean")
	private LoginUserBean loginUserBean;


	public UserController(UserService userService){
		this.userService = userService;
	}


	@GetMapping("/login")
	public String login(@ModelAttribute("loginBean") LoginUserBean loginBean,
						Model model,
						@RequestParam(value = "fail", defaultValue = "false") boolean fail) {
		model.addAttribute("fail", fail);
		return "user/login";
	}

	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("loginBean")LoginUserBean loginBean, BindingResult result){
		if (result.hasErrors()){
			return "user/login";
		}

		userService.getLoginUserInfo(loginBean);

		if(loginUserBean.isUserLogin()) {
			return "user/login_success";
		} else {
			return "user/login_fail";
		}


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

		userService.addUserInfo(joinUserBean);
		return "user/join_success";
	}


	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	
	@GetMapping("/logout")
	public String logout() {
		loginUserBean.setUserLogin(false);
		return "user/logout";
	}
}
