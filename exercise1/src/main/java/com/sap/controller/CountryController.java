package com.sap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sap.service.CountryService;
import com.sap.entity.Country;
import com.sap.entity.User;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		return countryService.getAll();
	}
	
	@GetMapping("/countries/{id}")
	public Country getCountryById(@PathVariable int id) {
		return countryService.findById(id);
	}
	@GetMapping("/countries/{id}/users")
	public List<User> getUsersByCountry(@PathVariable int id) {
		return countryService.getUserListByCountry(id);
	}
	@GetMapping("/countries/{id}/users/count")
	public int getUsersCountByCountry(@PathVariable int id) {
		return countryService.countUsersByCountry(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/countries")
	public Country createCountry(@RequestBody Country country) {
		return countryService.create(country);
	}
	
	@PutMapping("/countries")
	public Country updateCountry(@RequestBody Country country){
		return countryService.update(country);
	}
	
	@DeleteMapping("/countries/{id}")
	public void deleteCountry(@PathVariable int id) {
		countryService.delete(id);
	}
}
