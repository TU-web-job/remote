package com.remote.reserve.form;

import java.time.LocalDate;

import com.remote.reserve.dto.ReserveDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResConfirmForm {

	
	private LocalDate reserveDate;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String email;
	
	private String memo;
	
	public ReserveDTO toDTO() {
		return ReserveDTO.builder().name(this.name).reserveDate(this.reserveDate).email(this.email).memo(this.memo).build();
	}
}
