package com.ty.VaccinationCenter.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.VaccinationCenter.dto.VaccinationCenter;
import com.ty.VaccinationCenter.repository.VaccinationCenterRepository;

@Repository
public class VaccinationCenterDao {

	@Autowired
	private VaccinationCenterRepository vaccinationCenterRepository;

	public VaccinationCenter save(VaccinationCenter vaccinationCenter) {
		return vaccinationCenterRepository.save(vaccinationCenter);
	}

	public VaccinationCenter getById(int id) {
		Optional<VaccinationCenter> center = vaccinationCenterRepository.findById(id);
		if (center.isEmpty()) {
			return null;
		} else {
			return center.get();
		}
	}
}
