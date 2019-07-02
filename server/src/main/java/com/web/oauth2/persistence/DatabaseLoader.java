package com.web.oauth2.persistence;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseLoader {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void init() {
		if (repository.findByUserName("admin") == null) {
			User user = new User();
			user.setUserName("admin");
			user.setPassword("admin");
			repository.save(user);
		}
	}
}
