package com.remote.reserve.service;

import com.remote.reserve.dto.ReserveDTO;

public interface ReserveService {
	
	public void reserveCon(String name, String email, ReserveDTO dto);

	public ReserveDTO findReserve(String name,ReserveDTO dto);
}
