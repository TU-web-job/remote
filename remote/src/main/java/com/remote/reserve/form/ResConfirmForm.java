package com.remote.reserve.form;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResConfirmForm {

	
	private Date reserveDate;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String email;
	
	private String memo;
}
