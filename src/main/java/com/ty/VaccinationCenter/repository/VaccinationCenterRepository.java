package com.ty.VaccinationCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.VaccinationCenter.dto.VaccinationCenter;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {
	
	
}
