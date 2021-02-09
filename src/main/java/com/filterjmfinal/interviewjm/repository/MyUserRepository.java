package com.filterjmfinal.interviewjm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.filterjmfinal.interviewjm.model.MyUser;

public interface MyUserRepository extends CrudRepository<MyUser,Integer>{
	
	
	//////Match Filters//////
	List<MyUser> findByFirstName(String firstName);
	List<MyUser> findBySurName(String surName);
	List<MyUser> findByRole(String role);
	List<MyUser> findByAge(int age);
	
	
	//////Age Filters//////
	List<MyUser> findByAgeLessThan(int age);
	List<MyUser> findByAgeGreaterThan(int age);
	List<MyUser> findByAgeBetween(int low, int high);
	
	//////And Filters//////
	List<MyUser> findByFirstNameAndSurNameIgnoreCase(String first, String last);
	List<MyUser> findByFirstNameAndRoleIgnoreCase(String first, String role);
	List<MyUser> findByFirstNameIgnoreCaseAndAge(String first, int age);
	List<MyUser> findBySurNameAndRoleIgnoreCase(String last, String role);
	List<MyUser> findBySurNameIgnoreCaseAndAge(String last, int age);
	List<MyUser> findByRoleIgnoreCaseAndAge(String role, int age);
	
	//////Or Filters//////
	List<MyUser> findByFirstNameOrSurNameIgnoreCase(String first, String last);
	List<MyUser> findByFirstNameOrRoleIgnoreCase(String first, String role);
	List<MyUser> findByFirstNameIgnoreCaseOrAge(String first, int age);
	List<MyUser> findBySurNameOrRoleIgnoreCase(String last, String role);
	List<MyUser> findBySurNameIgnoreCaseOrAge(String last, int age);
	List<MyUser> findByRoleIgnoreCaseOrAge(String role, int age);
	
	//////Exclude(NOT) Filters//////
	List<MyUser> findByFirstNameNotIgnoreCase(String firstName);
	List<MyUser> findBySurNameNotIgnoreCase(String lastName);
	List<MyUser> findByAgeNot(int age);
	List<MyUser> findByRoleNotIgnoreCase(String role);
	 
}
