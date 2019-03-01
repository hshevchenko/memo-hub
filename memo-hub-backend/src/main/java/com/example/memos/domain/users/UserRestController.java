package com.example.memos.domain.users;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	@Autowired
	private UserService service;
	
		
	@PostMapping("users/sign-up")
	public User register(@RequestBody User user) {
		return service.save(user);
	}	
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	@CrossOrigin
	@RequestMapping("/login")
	public Principal user(Principal principal) {
		System.out.println("user logged "+principal);
		return principal;
	}
}
