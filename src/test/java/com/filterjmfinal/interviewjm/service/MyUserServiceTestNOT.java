package com.filterjmfinal.interviewjm.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.filterjmfinal.interviewjm.model.MyUser;
import com.filterjmfinal.interviewjm.repository.MyUserRepository;

public class MyUserServiceTestNOT {
	@Autowired
	private MyUserService myUserService;
	
	@MockBean
	private MyUserRepository myUserRepository;
	
		
	private List<MyUser> getTestData() {
		MyUser user1 = new MyUser();
		MyUser user2 = new MyUser();
		
		user1.setId(1);
		user1.setFirstName("Bob");
		user1.setSurName("Smith");
		user1.setRole("engineer");
		user1.setAge(55);
		
		
		user2.setId(2);
		user2.setFirstName("Marsha");
		user2.setSurName("Marley");
		user2.setRole("teacher");
		user2.setAge(23);
		
		List<MyUser> users = new ArrayList<MyUser>();
		users.add(user1);
		users.add(user2);
		
		return users;
	}
	
	@Test
	public void excludeUsersByFirstNameTest() {
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(1);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		Mockito.when(myUserRepository.findByFirstNameNotIgnoreCase("Bob")).thenReturn(query);
		assertThat(myUserService.excludeUsersByFirstName("Bob")).isEqualTo(query);
	}
		
	@Test
	public void excludeUsersBySurNameTest() {
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(1);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		Mockito.when(myUserRepository.findBySurNameNotIgnoreCase("Smith")).thenReturn(query);
		assertThat(myUserService.excludeUsersBySurName("Smith")).isEqualTo(query);
	}
	
	@Test 
	public void excludeUsersByRoleTest() {
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(1);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		Mockito.when(myUserRepository.findByRoleNotIgnoreCase("engineer")).thenReturn(query);
		assertThat(myUserService.excludeUsersByRole("engineer")).isEqualTo(query);
	}
	
	@Test
	public void excludeUsersByAgeTest() {
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(1);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		Mockito.when(myUserRepository.findByAgeNot(55)).thenReturn(query);
		assertThat(myUserService.excludeUsersByAge(55)).isEqualTo(query);
	}	
}
