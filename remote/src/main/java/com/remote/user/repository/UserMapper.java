package com.remote.user.repository;

import org.apache.ibatis.annotations.Mapper;

import com.remote.user.entity.UserEntity;

@Mapper
public interface UserMapper {

	void confirmUser(UserEntity entity);
	
	public UserEntity loginUser(String email, String password);
}
