package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.user.User;

@Service
public interface UserService extends BaseService<User> {
	
	User findByLogin(String login);
	
	Page<User> findByProfileId(String profileId, int page, int count);
	
	Page<User> findByLdapUser(boolean ldapUser, int page, int count);
	
}
