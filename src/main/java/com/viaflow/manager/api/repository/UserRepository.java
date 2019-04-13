package com.viaflow.manager.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.user.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	User findByLogin(String login);
	
	Page<User> findByProfileProfileId(String profileId, Pageable pages);
	
	Page<User> findByLdapUser(boolean ldapUser, Pageable pages);
	
}
