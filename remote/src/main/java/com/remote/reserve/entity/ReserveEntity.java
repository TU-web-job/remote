package com.remote.reserve.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserve")
@Data
public class ReserveEntity {

	private Date reserveDate;
	
	private String name;
	
	@Id
	private String email;
	
	private String memo;
}
