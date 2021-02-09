package com.filterjmfinal.interviewjm.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.filterjmfinal.interviewjm.model.MyUser;
import com.filterjmfinal.interviewjm.repository.MyUserRepository;

public class MyUserServiceTestAND {
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
	public void getUsersByFirstandSurTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findByFirstNameAndSurNameIgnoreCase("Bob", "Smith")).thenReturn(query);
	        		assertThat(myUserService.getUsersByFirstAndSur("Bob", "Smith")).isEqualTo(query);
	            });
		

	}
	
	@Test
	public void getUsersByFirstandRoleTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findByFirstNameAndRoleIgnoreCase("Bob", "engineer")).thenReturn(query);
	        		assertThat(myUserService.getByFirstAndRole("Bob", "engineer")).isEqualTo(query);
	            });
		

	}
		
	@Test
	public void getUsersByFirstandAgeTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findByFirstNameIgnoreCaseAndAge("Bob", 55)).thenReturn(query);
	        		assertThat(myUserService.getUsersByFirstAndAge("Bob", 55)).isEqualTo(query);
	            });

	}
	
	@Test
	public void getUsersBySurandRoleTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findBySurNameAndRoleIgnoreCase("Smith", "engineer")).thenReturn(query);
	        		assertThat(myUserService.getUsersBySurAndRole("Smith", "engineer")).isEqualTo(query);
	            });
		

	}
	
	@Test
	public void getUsersBySurandAgeTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findBySurNameIgnoreCaseAndAge("Smith", 55)).thenReturn(query);
	        		assertThat(myUserService.getUsersBySurNameAndAge("Smith", 55)).isEqualTo(query);
	            });

	}
	
	@Test
	public void getUsersByRoleAndAgeTest() {		
		List<MyUser> users = getTestData();
		MyUser testUser = users.get(0);
		List<MyUser> query = new ArrayList<>();
		query.add(testUser);
		
	    assertThrows(NullPointerException.class,
	            ()->{
	        		Mockito.when(myUserRepository.findByRoleIgnoreCaseAndAge("engineer", 55)).thenReturn(query);
	        		assertThat(myUserService.getUsersByRoleAndAge("engineer", 55)).isEqualTo(query);
	            });
		

	}
}
