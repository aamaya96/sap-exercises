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

import com.sap.entity.User;
import com.sap.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAll();
	}
	@GetMapping("/users/{userName}")
	public User getUserByUserName(@PathVariable String userName){
		return userService.findById(userName);
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		System.out.println(user.getUserName());
		return userService.create(user);
	}
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return userService.update(user);
	}
	@DeleteMapping("/users/{userName}")
	public void deleteUser(@PathVariable String userName) {
		userService.delete(userName);
	}
}
