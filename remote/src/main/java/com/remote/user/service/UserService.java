package com.remote.user.service;

import com.remote.user.dto.UserDTO;

public interface UserService {

	public void signup(UserDTO dto) throws Exception;
	
	public UserDTO findUser(UserDTO dto) throws Exception;
}
