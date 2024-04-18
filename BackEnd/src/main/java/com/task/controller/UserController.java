package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.exception.UserException;
import com.task.model.User;
import com.task.repo.UserRepo;
import com.task.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/signUp")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException {

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.CREATED);

	}

	@GetMapping("/signIn")
	public ResponseEntity<User> getLogged(Authentication auth) throws UserException {

		User user=userRepo.findByUserName(auth.getName()).orElseThrow(()-> new BadCredentialsException("Wrong User"));

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
}
