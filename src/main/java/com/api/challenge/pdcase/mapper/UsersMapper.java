package com.api.challenge.pdcase.mapper;

import org.mapstruct.Mapper;

import com.api.challenge.pdcase.model.Users;
import com.api.challenge.pdcase.model.dto.UsersDTO;

@Mapper(componentModel = "spring")
public interface UsersMapper {

	Users toEntity(UsersDTO dto);
	
	UsersDTO toDto(Users entity);
}
