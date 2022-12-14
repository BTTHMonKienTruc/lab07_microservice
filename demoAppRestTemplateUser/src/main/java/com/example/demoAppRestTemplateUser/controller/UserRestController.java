package com.example.demoAppRestTemplateUser.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demoAppRestTemplateUser.entity.User;

@RestController
public class UserRestController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("get-for-object")
	public User getForObject() {
		int id = 2;
		return restTemplate.getForObject("/" + id, User.class);
	}

	@GetMapping("get-for-entity")
	public User getForEntity() {
		int id = 3;
		ResponseEntity<User> entity = restTemplate.getForEntity("/" + id, User.class);

		return entity.getBody();
	}

	@GetMapping("users")
	public List<User> getUsers() {
		String URI_User = "http://localhost:8080/api/user";
		User[] forNow = restTemplate.getForObject(URI_User, User[].class);
		List<User> searchList = Arrays.asList(forNow);
		return searchList;
	}

	@GetMapping("users/{id}")
	public User getUser(@PathVariable int id) {
		return restTemplate.getForObject("/" + id, User.class);
	}
	//

	@PostMapping("/users") // post-for-object
	public User addEmployee(@RequestBody User user) {
		return restTemplate.postForObject("/", user, User.class);

	}

	//
	@PutMapping("/users")
	public void updateUser(@RequestBody User user) {

		restTemplate.postForObject("/", user, User.class);

	}

	//
	@DeleteMapping("/users/{id}")
	public boolean delUser(@PathVariable int id) {
		try {

			restTemplate.delete("/" + id);
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

}
