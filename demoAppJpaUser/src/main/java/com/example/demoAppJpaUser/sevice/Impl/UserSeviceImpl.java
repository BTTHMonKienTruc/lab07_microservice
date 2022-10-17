package com.example.demoAppJpaUser.sevice.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoAppJpaUser.entity.User;
import com.example.demoAppJpaUser.repository.UserRepository;
import com.example.demoAppJpaUser.sevice.UserSevice;

@Transactional
@Service
public class UserSeviceImpl implements UserSevice{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(int maTim) {
		// TODO Auto-generated method stub
		Optional<User> result = userRepository.findById(maTim);
		User a = null;
		if (result.isPresent()) {
			a = result.get();
		}
		else {
			throw new RuntimeException("khonog tim thay ma - "+ maTim);
//			return null;
		}
		
		return a;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public void delete(int maXoa) {
		// TODO Auto-generated method stub
		userRepository.deleteById(maXoa);
	}

}
