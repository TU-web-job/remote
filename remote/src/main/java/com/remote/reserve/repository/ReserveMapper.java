package com.remote.reserve.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.remote.reserve.entity.ReserveEntity;

@Mapper
public interface ReserveMapper {

	void confirmReserve(ReserveEntity entity);
	
	public List<ReserveEntity> findReserve(String email);
}
