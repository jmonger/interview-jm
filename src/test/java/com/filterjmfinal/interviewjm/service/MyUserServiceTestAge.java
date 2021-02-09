package com.filterjmfinal.interviewjm.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.filterjmfinal.interviewjm.model.MyUser;
import com.filterjmfinal.interviewjm.repository.MyUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUserServiceTestAge {
	
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
	public void getUsersByAgeLessThanTest() {
		List<MyUser> users = getTestData();
		List<MyUser> query = new ArrayList<>();
		MyUser testUser = users.get(1);
		query.add(testUser);
		Mockito.when(myUserRepository.findByAgeLessThan(25)).thenReturn(query);
		assertThat(myUserService.getUsersByAgeLessThan(25)).isEqualTo(query);
	}
	
	@Test
	public void getUsresByAgeGreaterThanTest() {
		List<MyUser> users = getTestData();
		List<MyUser> query = new ArrayList<>();
		MyUser testUser = users.get(0);
		query.add(testUser);
		Mockito.when(myUserRepository.findByAgeGreaterThan(25)).thenReturn(query);
		assertThat(myUserService.getUsersByAgeGreaterThan(25)).isEqualTo(query);
	}
	
	@Test
	public void getUsersByAgeBetweenTest() {
		List<MyUser> users = getTestData();		
		Mockito.when(myUserRepository.findByAgeBetween(20, 60)).thenReturn(users);
		assertThat(myUserService.getUsersByAgeBetween(20,60)).isEqualTo(users);
	}

}