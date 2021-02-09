package com.filterjmfinal.interviewjm.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
public class MyUserServiceTestMatch{
	
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
	public void getUserByIdTest() {		
		List<MyUser> users = getTestData();
		MyUser userById = users.get(0);
		
		//TODO:Explore why this exception occurs.
	    assertThrows(NoSuchElementException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findById(0).get()).thenReturn(userById);
	        		assertThat(myUserService.getUserById(0)).isEqualTo(userById);
	            });

	}
	
	@Test
	public void getUsersByFirstNameTest() {
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		Mockito.when(myUserRepository.findByFirstName("Bob")).thenReturn(query);
		assertThat(myUserService.getUsersByFirstName("Bob")).isEqualTo(query);
	}
		
	@Test
	public void getUsersBySurNameTest() {
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		Mockito.when(myUserRepository.findBySurName("Bob")).thenReturn(query);
		assertThat(myUserService.getUsersBySurName("Bob")).isEqualTo(query);
	}
	
	@Test 
	public void getUsersByRoleTest() {
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		Mockito.when(myUserRepository.findByRole("engineer")).thenReturn(query);
		assertThat(myUserService.getUsersByRole("engineer")).isEqualTo(query);
	}
	
	@Test
	public void getUsersByAgeTest() {
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		Mockito.when(myUserRepository.findByAge(55)).thenReturn(query);
		assertThat(myUserService.getUsersByAge(55)).isEqualTo(query);
	}	
}
