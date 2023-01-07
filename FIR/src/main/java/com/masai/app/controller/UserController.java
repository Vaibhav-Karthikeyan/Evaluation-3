package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.entity.Fir;
import com.masai.app.entity.Login;
import com.masai.app.entity.User;
import com.masai.app.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/masaifir")
public class UserController {
	@Autowired
	UserService ser;
	
	@PostMapping("/user/register")
	public ResponseEntity<?> newUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(ser.newUser(user), HttpStatus.CREATED); 
	}	
	
	@PostMapping("/user/login")
	public ResponseEntity<?> login(@Valid @RequestBody Login login) {
		return new ResponseEntity<String>(ser.postUser(login), HttpStatus.OK); 
	}
	
	@GetMapping("/user/{userId}/fir/")
	public ResponseEntity<?> allFir(@Valid @PathVariable int userId) {
		return new ResponseEntity<List<Fir>>(ser.allFir(userId), HttpStatus.OK); 
	}	
	
	@PostMapping("/user/{userId}/fir/")
	public ResponseEntity<?> newFir(@Valid @RequestBody Fir fir,@PathVariable int userId ) {
		return new ResponseEntity<User>(ser.newFir(userId, fir), HttpStatus.CREATED); 
	}	
}
