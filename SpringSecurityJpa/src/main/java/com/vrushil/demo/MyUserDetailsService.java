package com.vrushil.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user =		repo.findByUserName(userName);
	
		user.orElseThrow(()-> new UsernameNotFoundException("Username "+ userName+ " not found!"));
		return user.map(MyUserDetails::new).get();
		/*
		 * return new MyUserDetails(username);
		 */	}

}
