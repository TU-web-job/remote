package com.remote.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.remote.user.dto.UserDTO;

@Mapper
public interface UserMapper {

	public int confirmUser();
	
	public List<UserDTO> selectUser(String email);
}
