package com.remote.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.remote.user.dto.UserDTO;
import com.remote.user.form.UserConfigForm;
import com.remote.user.form.UserLoginForm;
import com.remote.user.service.UserService;

import jakarta.servlet.http.HttpSession;
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
	
	private final UserService userService;
	
	@GetMapping
	public String init() {
		return Init;
	}
	
	@PostMapping(params = "signup")
	public String getSignup(@ModelAttribute("userConfig") UserConfigForm form, Model model) {
		model.addAttribute("userConfig", form);
		return Signup;
	}
	
	@PostMapping(params = "login")
	public String getLogin(@ModelAttribute("userLogin") @Valid UserLoginForm form,Model model) {
		model.addAttribute("userLogin", form);
		return Login;
	}
	
	@PostMapping(params = "btn_signup")
	public String signup(@ModelAttribute("userConfig") @Valid UserConfigForm form,BindingResult result ,Model model) {
		if(!result.hasErrors()) {
			try {
				UserDTO dto = form.toDTO();
				userService.signup(dto);
				model.addAttribute("userConfig",form);
			}catch(Exception e) {
				model.addAttribute("errors", e.getMessage());
				e.printStackTrace();
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
				UserDTO dto = userService.findUser(form.toDTO());
				model.addAttribute("userLogin", dto);
			}catch(Exception e) {
				model.addAttribute("errors", e.getMessage());
				e.printStackTrace();
				return Login;
			}
			return Result;
		}
		return Login;
	}
	
	@PostMapping(params = "btn_reserve")
	public String toReserve(@ModelAttribute("userLogin") @Valid UserLoginForm form,HttpSession session, BindingResult result, Model model) {
		if(!result.hasErrors()) {
			try {
				UserDTO dto = userService.findUser(form.toDTO());
				session.setAttribute("loginUser", dto);
				}catch(Exception e) {
				model.addAttribute("errors", e.getMessage());
				e.printStackTrace();
				return Login;
			}
			return "redirect:/reserve/init";
		}
		return Login;
	}
	
	
}
