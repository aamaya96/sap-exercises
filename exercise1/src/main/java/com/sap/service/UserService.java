package com.sap.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.entity.User;
import com.sap.repository.UserRepository;


@Service
public class UserService extends AbstractService<User,String>{
	@Autowired
	public UserService(UserRepository repository) {
		super(repository);
	}
	
}
