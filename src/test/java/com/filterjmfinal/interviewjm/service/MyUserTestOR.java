package com.filterjmfinal.interviewjm.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.filterjmfinal.interviewjm.model.MyUser;
import com.filterjmfinal.interviewjm.repository.MyUserRepository;

public class MyUserTestOR {

	
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
	public void getUsersByFirstOrSurTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(1);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findByFirstNameOrSurNameIgnoreCase("Bob", "Smith")).thenReturn(query);
	        		assertThat(myUserService.getUsersByFirstOrSur("Bob", "Smith")).isEqualTo(query);
	            });
		

	}
	
	@Test
	public void getUsersByFirstOrRoleTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findByFirstNameOrRoleIgnoreCase("Bob", "engineer")).thenReturn(query);
	        		assertThat(myUserService.getByFirstOrRole("Bob", "engineer")).isEqualTo(query);
	            });
		

	}
		
	@Test
	public void getUsersByFirstOrAgeTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findByFirstNameIgnoreCaseOrAge("Bob", 55)).thenReturn(query);
	        		assertThat(myUserService.getUsersByFirstOrAge("Bob", 55)).isEqualTo(query);
	            });
		

	}
	
	@Test
	public void getUsersBySurOrRoleTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findBySurNameOrRoleIgnoreCase("Smith", "engineer")).thenReturn(query);
	        		assertThat(myUserService.getUsersBySurOrRole("Smith", "engineer")).isEqualTo(query);
	            });
		

	}
	
	@Test
	public void getUsersBySurOrAgeTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findBySurNameIgnoreCaseOrAge("Smith", 55)).thenReturn(query);
	        		assertThat(myUserService.getUsersBySurNameOrAge("Smith", 55)).isEqualTo(query);
	            });
		

	}
	
	@Test
	public void getUsersByRoleOrAgeTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findByRoleIgnoreCaseOrAge("engineer", 55)).thenReturn(query);
	        		assertThat(myUserService.getUsersByRoleOrAge("engineer", 55)).isEqualTo(query);
	            });
		

	}
}
