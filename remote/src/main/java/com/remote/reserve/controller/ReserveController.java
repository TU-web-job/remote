package com.remote.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.remote.reserve.form.ResConfirmForm;
import com.remote.reserve.service.ReserveService;
import com.remote.user.dto.UserDTO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "reserve")
@RequiredArgsConstructor
public class ReserveController {

	private static final String Reserve = "reserve/";
	
	private static final String Init = Reserve + "init";
	
	private static final String Confirm = Reserve + "resConFirm";
	
	private static final String ResFind = Reserve + "resFind";
	
	private static final String Result = Reserve + "result";

	private final ReserveService reserveService;
	
	@GetMapping
	public String getInit(HttpSession session, Model model) throws Exception{
		UserDTO dto = (UserDTO) session.getAttribute("loginUser");
		if(dto == null) {
			return "user/login";
		}
		
		model.addAttribute("loginUser",(UserDTO) session.getAttribute("loginUser"));
		
		return Init;
	}
	
	@PostMapping(params = "btn_reserve")
	public String toInit(HttpSession session, Model model) {
		UserDTO dto = (UserDTO) session.getAttribute("loginUser");
		model.addAttribute("loginUser", dto);
		return Init;
	}
	
	@PostMapping(params = "resConFirm")
	public String getResConFirm(@ModelAttribute("resConForm")ResConfirmForm form,HttpSession session, Model model) {
		UserDTO dto = (UserDTO) session.getAttribute("loginUser");
		model.addAttribute("loginUser", dto);
		return Confirm;
	}
	
	@PostMapping(params = "btn_conResFirm")
	public String confrim(@ModelAttribute("resConForm") ResConfirmForm form,HttpSession session,Model model) {
		UserDTO dto = (UserDTO) session.getAttribute("loginUser");
		reserveService.reserveCon(dto.getName(),dto.getEmail(),form.toDTO());
		model.addAttribute("loginUser",dto);
		model.addAttribute("resConForm");
		return Result;
	}
	
	@PostMapping(params = "btn_resFind")
	public String find(Model model) {
		return ResFind;
	}

}
