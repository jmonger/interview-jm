package com.filterjmfinal.interviewjm.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filterjmfinal.interviewjm.model.MyUser;
import com.filterjmfinal.interviewjm.repository.MyUserRepository;

@Service
@Transactional
public class MyUserService {
	@Autowired
	MyUserRepository userRepository;
	
	public List<MyUser> getAllUsers() {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;		
	}
	
	public MyUser saveUser(MyUser user) {
		return userRepository.save(user);	
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////MATCH FILTER SERVICES////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public MyUser getUserById(int id) {
		return userRepository.findById(id).get();
	}	
	public List<MyUser> getUsersByFirstName(String firstName) {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByFirstName(firstName).forEach(user -> users.add(user));
		return users;		
	}
	public List<MyUser> getUsersBySurName(String surName) {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findBySurName(surName).forEach(user -> users.add(user));
		return users;		
	}	
	public List<MyUser> getUsersByRole(String role) {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByRole(role).forEach(user -> users.add(user));
		return users;		
	}	
	public List<MyUser> getUsersByAge(int age) {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByAge(age).forEach(user -> users.add(user));
		return users;		
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////AGE FILTER SERVICES//////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<MyUser> getUsersByAgeLessThan(int age) {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByAgeLessThan(age).forEach(user -> users.add(user));
		return users;
	}
	
	public List<MyUser> getUsersByAgeGreaterThan(int age) {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByAgeGreaterThan(age).forEach(user -> users.add(user));
		return users;
	}
		
	public List<MyUser> getUsersByAgeBetween(int low, int high) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByAgeBetween(low,high).forEach(user -> users.add(user));
		return users;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////AND FILTER SERVICES///////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<MyUser> getUsersByFirstAndSur(String first, String sur) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByFirstNameAndSurNameIgnoreCase(first,sur).forEach(user -> users.add(user));
		return users;
	}
	
	public List<MyUser> getByFirstAndRole(String first, String role) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByFirstNameAndRoleIgnoreCase(first,role).forEach(user -> users.add(user));
		return users;
	}
	
	public List<MyUser> getUsersByFirstAndAge(String first, int age) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByFirstNameIgnoreCaseAndAge(first,age).forEach(user -> users.add(user));
		return users;
	}
	
	
	public List<MyUser> getUsersBySurAndRole(String sur, String role) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findBySurNameAndRoleIgnoreCase(sur,role).forEach(user -> users.add(user));
		return users;
	}
	
	public List<MyUser> getUsersBySurNameAndAge(String surName, int age) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByRoleIgnoreCaseAndAge(surName,age).forEach(user -> users.add(user));
		return users;
	}
	
	
	public List<MyUser> getUsersByRoleAndAge(String role, int age) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByRoleIgnoreCaseAndAge(role,age).forEach(user -> users.add(user));
		return users;
	}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////OR FILTER SERVICES///////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<MyUser> getUsersByFirstOrSur(String first, String sur) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByFirstNameOrSurNameIgnoreCase(first,sur).forEach(user -> users.add(user));
		return users;
	}
	
	public List<MyUser> getByFirstOrRole(String first, String role) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByFirstNameOrRoleIgnoreCase(first,role).forEach(user -> users.add(user));
		return users;
	}
	
	public List<MyUser> getUsersByFirstOrAge(String first, int age) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByFirstNameIgnoreCaseOrAge(first,age).forEach(user -> users.add(user));
		return users;
	}
	
	
	public List<MyUser> getUsersBySurOrRole(String sur, String role) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findBySurNameOrRoleIgnoreCase(sur,role).forEach(user -> users.add(user));
		return users;
	}
	
	public List<MyUser> getUsersBySurNameOrAge(String surName, int age) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByRoleIgnoreCaseOrAge(surName,age).forEach(user -> users.add(user));
		return users;
	}
	
	
	public List<MyUser> getUsersByRoleOrAge(String role, int age) {		
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByRoleIgnoreCaseOrAge(role,age).forEach(user -> users.add(user));
		return users;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////NOT FILTER SERVICES////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<MyUser> excludeUsersByFirstName(String firstName) {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByFirstNameNotIgnoreCase(firstName).forEach(user -> users.add(user));
		return users;		
	}
	
	public List<MyUser> excludeUsersBySurName(String surName) {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findBySurNameNotIgnoreCase(surName).forEach(user -> users.add(user));
		return users;		
	}
	
	public List<MyUser> excludeUsersByRole(String role) {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByRoleNotIgnoreCase(role).forEach(user -> users.add(user));
		return users;		
	}
	
	public List<MyUser> excludeUsersByAge(int age) {
		List<MyUser> users = new ArrayList<MyUser>();
		userRepository.findByAgeNot(age).forEach(user -> users.add(user));
		return users;		
	}	
}
