package com.remote.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.remote.user.dto.UserDTO;
import com.remote.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "reserve")
@RequiredArgsConstructor
public class ReserveController {

	private static final String Reserve = "reserve/";
	
	private static final String Init = Reserve + "init";
	
	private static final String Confirm = Reserve + "resConfirm";
	
	private static final String ResFind = Reserve + "resFind";
	
	private static final String Result = Reserve + "result";
	
	private final UserService userService;
	
	@GetMapping
	public String getInit(HttpSession session, Model model) throws Exception{
		UserDTO uDTO = (UserDTO) session.getAttribute("loginUser");
		model.addAttribute("loginName", uDTO.getName());
		model.addAttribute("loginEmail", uDTO.getEmail());
		model.addAttribute("loginPassword",uDTO.getPassword());
		
		return Init;
	}
	
	@PostMapping(params = "resConfirm")
	public String confrim(Model model) {
		return Confirm;
	}
	
	@PostMapping(params = "resFind")
	public String find(Model model) {
		return ResFind;
	}
	
	@PostMapping(params = "btn_resConfirm")
	public String resConfirm(Model model) {
		
		return Result;
	}
	
	@PostMapping(params = "btn_resFind")
	public String resFind(Model model) {
		return Result;
	}
}
