package com.remote.reserve.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.remote.reserve.repository.ReserveMapper;
import com.remote.reserve.service.ReserveService;
import com.remote.user.repository.UserMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReserveServiceImpl implements ReserveService{

	private final UserMapper userMapper;
	
	private final ReserveMapper reserveMapper;
	
	private final HttpSession httpSession;
	
	public void ResCon() {
		
	}
}
