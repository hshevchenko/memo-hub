package com.example.memos.domain.users;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepository repository;
	
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);		
		if(user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.EMPTY_LIST);
		}
		return null;
	}
}
