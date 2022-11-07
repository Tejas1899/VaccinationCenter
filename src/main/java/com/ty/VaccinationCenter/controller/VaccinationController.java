package com.ty.VaccinationCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ty.VaccinationCenter.dao.VaccinationCenterDao;
import com.ty.VaccinationCenter.dto.Citizen;
import com.ty.VaccinationCenter.dto.Response;
import com.ty.VaccinationCenter.dto.VaccinationCenter;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

	@Autowired
	private VaccinationCenterDao vaccinationCenterDao;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/save")
	public ResponseEntity<VaccinationCenter> saveVaccine(@RequestBody VaccinationCenter vaccinationCenter) {
		VaccinationCenter center = vaccinationCenterDao.save(vaccinationCenter);
		return new ResponseEntity<VaccinationCenter>(center, HttpStatus.CREATED);
	}

	@GetMapping("/getAll/{id}")
	public ResponseEntity<Response> getAllDataBasedOnCenterID(@PathVariable int id) {
		Response response = new Response();

		VaccinationCenter center = vaccinationCenterDao.getById(id);
		response.setVaccinationCenter(center);
		List<Citizen> citizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/getAll/" + id, List.class);
		response.setCitizens(citizens);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}
