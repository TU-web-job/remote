package com.remote.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.remote.user.form.UserConfigForm;
import com.remote.user.form.UserLoginForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

	private static final String USER = "user/";
	
	private static final String Init  = USER + "/init";
	
	private static final String Signup = USER + "/signup";
	
	private static final String Login = USER + "/login";
	
	private static final String Result = USER + "/result";
	
	@GetMapping
	public String init() {
		return Init;
	}
	
	@PostMapping(params = "btn_signup")
	public String signup(@ModelAttribute("userConfig") @Valid UserConfigForm form,BindingResult result ,Model model) {
		if(!result.hasErrors()) {
			try {
				model.addAttribute("userConfig", form);
			}catch(Exception e) {
				model.addAttribute("errors", e.getMessage());
				return Signup;
			}
			return Result;
		}
		return Signup;
	}
	
	@PostMapping(params = "btn_login")
	public String login(@ModelAttribute("userLogin") @Valid UserLoginForm form, BindingResult result, Model model) {
		if(!result.hasErrors()) {
			try {
				model.addAttribute("userLogin", form);
			}catch(Exception e) {
				model.addAttribute("errors", e.getMessage());
				return Login;
			}
			return Result;
		}
		return Login;
	}
	
	
}
