package com.remote.user.repository;

import org.apache.ibatis.annotations.Mapper;

import com.remote.user.dto.UserDTO;

@Mapper
public interface UserMapper {

	public int confirmUser();
	
	public UserDTO loginUser(String email, String password);
}
