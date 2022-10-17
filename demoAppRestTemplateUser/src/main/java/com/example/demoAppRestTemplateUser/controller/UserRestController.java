package com.example.demoAppRestTemplateUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
