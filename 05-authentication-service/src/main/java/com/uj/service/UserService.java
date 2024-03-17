package com.uj.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.uj.entity.User;
import com.uj.repo.UserRepo;

@Component
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> findByEmail = repo.findByEmail(username);
		if(findByEmail.isPresent()) {
			return findByEmail.map(UserInfoService::new)
            .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
		}
		return null;
	}

}
