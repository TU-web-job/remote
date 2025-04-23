package com.remote.user.form;

import com.remote.user.dto.UserDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginForm {

	private String email;
	
	private String password;
	
	public UserLoginForm toForm() {
		return UserLoginForm.builder().email(this.email).password(this.password).build();
	}
	
	public UserDTO toDTO() {
		return UserDTO.builder().email(this.email).password(this.password).build();
	}
	
	
}
