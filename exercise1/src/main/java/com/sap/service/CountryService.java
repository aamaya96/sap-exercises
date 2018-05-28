package com.sap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.entity.Country;
import com.sap.entity.User;
import com.sap.repository.CountryRepository;

@Service
public class CountryService extends AbstractService<Country, Integer>{
	@Autowired
	public CountryService(CountryRepository repository) {
		super(repository);
		
	}
	public List<User> getUserListByCountry(int id){
		return this.findById(id).getUsers();
	}
	public int countUsersByCountry(int id) {
		return this.findById(id).getUsers().size();
	}
}
