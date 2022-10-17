package com.example.demoAppJpaUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoAppJpaUser.entity.User;
import com.example.demoAppJpaUser.sevice.UserSevice;

@RestController
@RequestMapping("/api")
public class UserController {

	private UserSevice userSevice;

	@Autowired
	public UserController(UserSevice userSevice) {
		super();
		this.userSevice = userSevice;
	}
	

	//
	@GetMapping("/")
	public String myhome() {
		return "my home";
	}
	//
	@GetMapping("/user")
	public List<User> getUsers() {
		return userSevice.findAll();
	}

	//
	@GetMapping("/user/{id}")
	public User getEmployee(@PathVariable int id) {
		User user = userSevice.findById(id);

		if (user == null) {
			throw new RuntimeException("Employee is not found - " + id);
		}
		return user;
	}
	//
	@PostMapping("/user")
	public User addEmployee(@RequestBody User user) {
//		user.setId(0);
		userSevice.save(user);
		return user;
	}

	//
	@PutMapping("/user")
	public User updateEmployee(@RequestBody User user) {
		userSevice.save(user);
		return user;
	}

//
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {

		User user = userSevice.findById(id);

		if (user == null) {

			throw new RuntimeException("Employee id not found -" + id);
		}

		userSevice.delete(id);

		return "Deleted employee with id : " + id;

	}
	
	
}
