package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserDetails;

@RestController
public class UserController {

	@Autowired
	UserDao dao;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserDetails userDetails) {
		return dao.saveUser(userDetails);
	} 
	
	@GetMapping("/users")
	public List<UserDetails> getAllUsers() {
		return dao.getAllUsers();
	}
	

	@GetMapping("/user/{uid}")
	public UserDetails getUserById(@PathVariable Integer uid) {
		return dao.getUser(uid);
	}
	
	@DeleteMapping("/delete/{uid}")
	public String deleteUser(@PathVariable Integer uid) {
		return dao.deleteUser(uid);
	}
}
