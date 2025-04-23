package com.remote.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

	private String name;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;
	
	public UserDTO toDTO() {
		return UserDTO.builder().name(this.name).email(this.email).password(this.password)
				.confirmPassword(this.confirmPassword).build();
	}
}
