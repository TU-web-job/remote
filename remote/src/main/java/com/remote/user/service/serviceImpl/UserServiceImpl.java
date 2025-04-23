package com.remote.user.service.serviceImpl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.remote.user.dto.UserDTO;
import com.remote.user.entity.UserEntity;
import com.remote.user.repository.UserMapper;
import com.remote.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserMapper userMapper;
	
	@Override
	public void signup(UserDTO dto) throws Exception{
		if(!dto.getPassword().equals(dto.getConfirmPassword())) {
			throw new IllegalArgumentException("パスワードが違います。");
		}
		
		UserEntity entity = new UserEntity();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
	}
	
	@Override
	public UserDTO findUser(UserDTO dto) throws Exception {
		String email = dto.getEmail();
		String password = dto.getPassword();
		UserDTO user = userMapper.loginUser(email, password);
		if(user.equals(null)) {
			throw new NoSuchElementException("メールアドレス　または　パスワードが違います。");
		}
		
		return UserDTO.builder().name(user.getName()).email(user.getEmail())
				.password(user.getPassword()).build();
	}
}
