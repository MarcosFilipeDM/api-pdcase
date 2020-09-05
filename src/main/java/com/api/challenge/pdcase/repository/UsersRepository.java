package com.api.challenge.pdcase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.challenge.pdcase.model.Users;
import com.api.challenge.pdcase.model.dto.UsersViewListDTO;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	@Query("select new com.api.challenge.pdcase.model.dto.UsersViewListDTO(u.id, u.username, u.enabled, u.registerDate, u.name, u.surName, u.email, u.phone) from Users u")
	List<UsersViewListDTO> readAllUsers();
	
}
