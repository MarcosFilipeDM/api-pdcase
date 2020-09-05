package com.api.challenge.pdcase.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.challenge.pdcase.mapper.UsersMapper;
import com.api.challenge.pdcase.model.Users;
import com.api.challenge.pdcase.model.dto.UsersDTO;
import com.api.challenge.pdcase.model.dto.UsersViewListDTO;
import com.api.challenge.pdcase.repository.UsersRepository;
import com.api.challenge.pdcase.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	private UsersRepository usersRepository;
	private UsersMapper usersMapper;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
		
	public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usersRepository = usersRepository;
		this.usersMapper = usersMapper;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public boolean createUser(UsersDTO userDto) {
		Users userEntity = usersMapper.toEntity(userDto);
		userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
		userEntity.setRegisterDate(new Date());
		return usersRepository.saveAndFlush(userEntity) != null;
	}

	@Override
	public List<UsersViewListDTO> readAllUsers() {		
		return usersRepository.readAllUsers();
	}

	@Override
	public UsersDTO getUser(Integer userId) {
		return usersMapper.toDto(usersRepository.findById(userId).get());
	}
	
	@Override
	public boolean updateUser(UsersDTO userDto) {
		Users userEntity = usersMapper.toEntity(userDto);
		userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
		return usersRepository.saveAndFlush(userEntity) != null;
	}

	@Override
	public void deleteUser(Integer userId) {
		usersRepository.deleteById(userId); 
	}

	@Override
	public void alterUserStatus(Integer userId) {
		Users userEntity = usersRepository.findById(userId).get();
		if(userEntity.isEnabled()) {
			userEntity.setEnabled(false);
		}else {
			userEntity.setEnabled(true);
		}
		usersRepository.saveAndFlush(userEntity);
	}

	@Override
	public boolean checkPassword(String pass, Integer userId) {
		return bCryptPasswordEncoder.matches(pass, usersRepository.findById(userId).get().getPassword());
	}

}
