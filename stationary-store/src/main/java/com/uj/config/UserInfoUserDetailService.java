package com.uj.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uj.entity.UsersMaster;
import com.uj.repo.UserMasterRepo;

@Service
public class UserInfoUserDetailService implements UserDetailsService{

	@Autowired
	private UserMasterRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsersMaster> findByEmail = repo.findByEmail(username);
		
		 return findByEmail.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
	}

}
