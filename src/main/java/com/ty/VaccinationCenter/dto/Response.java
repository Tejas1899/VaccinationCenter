package com.ty.VaccinationCenter.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
	private VaccinationCenter vaccinationCenter;
	private List<Citizen> citizens;
}
