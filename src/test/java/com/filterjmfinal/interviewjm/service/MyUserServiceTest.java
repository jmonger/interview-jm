package com.filterjmfinal.interviewjm.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

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
public class MyUserServiceTest {
	
	@Autowired
	private MyUserService myUserService;
	
	@MockBean
	private MyUserRepository myUserRepository;
	
	@Test
	public void createUserTest() {
		MyUser user = new MyUser();
		user.setId(1);
		user.setFirstName("Bob");
		user.setSurName("Smith");
		user.setRole("engineer");
		user.setAge(55);
		
		Mockito.when(myUserRepository.save(user)).thenReturn(user);
		assertThat(myUserService.saveUser(user)).isEqualTo(user);
	}
	
	@Test
	public void getAllUsersTest() {
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
		
		Mockito.when(myUserRepository.findAll()).thenReturn(users);
		assertThat(myUserService.getAllUsers()).isEqualTo(users);
			
	}
	

	

}
