package com.filterjmfinal.interviewjm.controller;

import java.util.ArrayList;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import com.filterjmfinal.interviewjm.model.MyUser;  
import com.filterjmfinal.interviewjm.service.MyUserService;  

@RestController
public class MyUserController {
	@Autowired
	MyUserService userService;
	
	@GetMapping("/user")
	private List<MyUser> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	private MyUser getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/user/first/{firstName}")
	private List<MyUser> getUsersByFirstName(@PathVariable("firstName") String firstName) {
		return userService.getUsersByFirstName(firstName);
	}
	
	@GetMapping("/user/sur/{surName}")
	private List<MyUser> getUsersBySurName(@PathVariable("surName") String surName) {
		return  userService.getUsersBySurName(surName);
	}
	
	@GetMapping("/user/role/{role}")
	private List<MyUser> getUsersByRole(@PathVariable("role") String role) {
		return userService.getUsersByRole(role);
	}
	
	@GetMapping("/user/age/{age}")
	private List<MyUser> getUsersByAge(@PathVariable("age") int age) {
		return userService.getUsersByAge(age);
	}
	
	
	
	
	@PostMapping("/myuser")
	private int saveMyUser(@RequestBody MyUser user) {
		userService.saveUser(user);
		return user.getId();
	}

}
