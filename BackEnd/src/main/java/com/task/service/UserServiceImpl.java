package com.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.exception.UserException;
import com.task.model.User;
import com.task.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User registerUser(User user) throws UserException {
		Optional<User> use = userRepo.findByUserName(user.getUserName());

		if (use.isPresent()) {
			throw new UserException("user already prensent");
		}

		return userRepo.save(user);
	}

}
