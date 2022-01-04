package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
		
	}

	@GetMapping(value = "/{username}")
	public ResponseEntity<UserDTO> loadUserByUsername(String username) throws UsernameNotFoundException{
		UserDTO dto = (UserDTO) service.loadUserByUsername(username);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/profile")
	public ResponseEntity<UserDTO> getProfile(Long id) {
		UserDTO dto = service.getProfile(id);
		return ResponseEntity.ok().body(dto);
	}
	
}
