package com.api.challenge.pdcase.service;

import java.util.List;

import com.api.challenge.pdcase.model.dto.UsersDTO;
import com.api.challenge.pdcase.model.dto.UsersViewListDTO;

public interface UsersService {

	boolean createUser(UsersDTO userDto);

	List<UsersViewListDTO> readAllUsers();

	UsersDTO getUser(Integer userId);

	boolean updateUser(UsersDTO userDto);

	void deleteUser(Integer userId);

	void alterUserStatus(Integer userId);

	boolean checkPassword(String pass, Integer userId);
}
