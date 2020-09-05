package com.api.challenge.pdcase.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.challenge.pdcase.model.dto.UsersDTO;
import com.api.challenge.pdcase.model.dto.UsersViewListDTO;
import com.api.challenge.pdcase.service.UsersService;

@RestController
@RequestMapping("/api/pd-case/users")
public class UsersController {

	private UsersService usersService;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@PostMapping
	public ResponseEntity<Boolean> createUser(@RequestBody UsersDTO user) {
		return ResponseEntity.ok(usersService.createUser(user));
	}
	
	@GetMapping
	public ResponseEntity<List<UsersViewListDTO>> readAllUsers() {
		return ResponseEntity.ok(usersService.readAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsersDTO> getUser(@PathVariable("id") Integer userId) {
		return ResponseEntity.ok(usersService.getUser(userId));
	}
	
	@PutMapping
	public ResponseEntity<Boolean> updateUser(@RequestBody UsersDTO user) {
		return ResponseEntity.ok(usersService.updateUser(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer userId) {
		usersService.deleteUser(userId);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/alter-status/{id}")
	public ResponseEntity<?> alterUserStatus(@PathVariable("id") Integer userId) {
		usersService.alterUserStatus(userId);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/check-password/{pass}/user/{id}")
	public ResponseEntity<Boolean> checkPassword(@PathVariable("pass") String pass, @PathVariable("id") Integer userId) {
		return ResponseEntity.ok(usersService.checkPassword(pass, userId));
	}
}
