package com.registration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.model.User;
import com.registration.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
}
