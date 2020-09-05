package com.api.challenge.pdcase.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.challenge.pdcase.model.dto.UsersDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(OrderAnnotation.class)
public class UsersServiceTest {

	@Autowired
	private UsersService usersService;
	
	@Test
	@Order(1)
	public void createUserT() {		
		UsersDTO user = new UsersDTO();
		user.setName("Marcos");
		user.setPassword("teste");
		assertTrue(usersService.createUser(user));
	}
	
	@Test
	@Order(2)
	public void getUserT() {
		UsersDTO user = usersService.getUser(1);
		assertEquals("Marcos", user.getName());
	}
	
	@Test
	@Order(3)
	public void readAllUsersT() {
		UsersDTO user = new UsersDTO();
		user.setName("Marcos Filipe");
		user.setPassword("teste usuario 2");
		usersService.createUser(user);		
		assertEquals(2, usersService.readAllUsers().size());
	}
	
	@Test
	@Order(4)
	public void updateUserT() {
		UsersDTO userDto = new UsersDTO();
		userDto.setId(1);
		userDto.setName("Marcos");
		userDto.setPassword("teste");
		userDto.setEmail("marcos@gmail.com");
		usersService.updateUser(userDto);
		
		UsersDTO user = usersService.getUser(1);
		assertEquals("marcos@gmail.com", user.getEmail());
	}
	
	@Test
	@Order(5)
	public void deleteUserT() {
		usersService.deleteUser(1);
		assertEquals(1, usersService.readAllUsers().size());
	}
	
	@Test
	@Order(6)
	public void alterUserStatusT() {
		usersService.alterUserStatus(2);
		assertTrue(usersService.getUser(2).isEnabled());
	}
	
	@Test
	@Order(7)
	public void checkPasswordT() {		
		assertTrue(usersService.checkPassword("teste usuario 2", 2));
	}
}
