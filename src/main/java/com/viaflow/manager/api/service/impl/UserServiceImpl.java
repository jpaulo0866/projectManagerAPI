package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.repository.UserRepository;
import com.viaflow.manager.api.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	protected UserRepository getRepo() {
		return this.repo;
	}
	
	@Override
	public User findByLogin(String login) {
		return this.repo.findByLogin(login);
	}

	@Override
	public Page<User> findByProfileId(String profileId, int page, int count) {
		Pageable pages= PageRequest.of(page, count);
		return this.getRepo().findByProfileProfileId(profileId, pages);
	}

	@Override
	public Page<User> findByLdapUser(boolean ldapUser, int page, int count) {
		Pageable pages= PageRequest.of(page, count);
		return this.getRepo().findByLdapUser(ldapUser, pages);
	}

		
}
