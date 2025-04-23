package com.remote.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "reserve")
@RequiredArgsConstructor
public class ReserveController {

	private static final String Reserve = "reserve/";
	
	private static final String Init = Reserve + "init";
	
	@GetMapping
	public String getInit() {
		return Init;
	}
}
