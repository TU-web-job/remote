package com.remote.reserve.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.remote.reserve.dto.ReserveDTO;
import com.remote.reserve.entity.ReserveEntity;
import com.remote.reserve.repository.ReserveMapper;
import com.remote.reserve.service.ReserveService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReserveServiceImpl implements ReserveService{

	private final ReserveMapper reserveMapper;
		
	@Override
	public void reserveCon(String name, String email, ReserveDTO dto) {
		ReserveEntity entity = new ReserveEntity();
		if(dto.getReserveDate() == null) {
			throw new NullPointerException("日付が未入力です");
		}
		entity.setName(name);
		entity.setEmail(email);
		entity.setReserveDate(dto.getReserveDate());
		entity.setMemo(dto.getMemo());
		
		reserveMapper.confirmReserve(entity);
	}
	
	/* reserve check */
	@Override
	public ReserveDTO findReserve(String name,ReserveDTO dto) {
		
		return ReserveDTO.builder().build();
	}
}
