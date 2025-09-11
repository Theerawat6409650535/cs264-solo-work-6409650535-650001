package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import java.util.List;


// 1.annotation 
@RestController
@RequestMapping("/api/users") // request this url
public class UserController { // Open API : get method API (pull data from database), post method API (push user's object into database)
	@Autowired
	private UserRepository userRepository; // 1 controller can use many repositories

	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

}
