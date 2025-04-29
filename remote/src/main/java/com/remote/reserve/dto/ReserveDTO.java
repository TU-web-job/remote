package com.remote.reserve.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReserveDTO {

	private String name;
	
	private String email;
	
	private LocalDate reserveDate;
	
	private String memo;
	
	public ReserveDTO toDTO() {
		return ReserveDTO.builder().name(this.name).email(this.email).reserveDate(this.reserveDate).memo(this.memo).build();
	}
}
