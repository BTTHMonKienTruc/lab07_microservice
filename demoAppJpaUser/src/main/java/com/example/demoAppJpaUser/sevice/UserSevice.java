package com.example.demoAppJpaUser.sevice;

import java.util.List;

import com.example.demoAppJpaUser.entity.User;

public interface UserSevice {

	public List<User> findAll();
	public User findById(int maTim);
	public void save(User user);
	public void delete (int maXoa);
}
