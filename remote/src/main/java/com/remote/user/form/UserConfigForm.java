package com.remote.user.form;

import com.remote.user.dto.UserDTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserConfigForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(min = 8, max = 16)
	@Pattern(regexp = "^ [a-zA-Z0-9]+$")
	private String password;
	
	@NotBlank
	@Size(min = 8, max = 16)
	@Pattern(regexp = "^ [a-zA-Z0-9]+$")
	private String confirmPassword;
	
	public UserConfigForm toForm() {
		return UserConfigForm.builder().name(this.name).email(this.email).password(this.password).confirmPassword(this.confirmPassword).build();
	}
	
	public UserConfigForm toDTO(UserDTO dto) {
		return UserConfigForm.builder().name(dto.getName()).email(dto.getEmail()).password(dto.getPassword()).build();
	}
}
