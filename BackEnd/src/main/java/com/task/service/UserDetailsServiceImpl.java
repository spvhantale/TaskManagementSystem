package com.task.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.task.model.User;
import com.task.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> opt=userRepo.findByUserName(username);
		
		if(opt.isPresent()) {
			User user=opt.get();
			List<GrantedAuthority> authorites=new ArrayList<>();
			
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorites);
		}
		
		throw new BadCredentialsException("wrong username");
		
	}
}
