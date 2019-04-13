package com.viaflow.manager.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.user.Profile;

@Repository
public interface ProfileRespository extends MongoRepository<Profile, String> {
	List<Profile> findAllByProfileNameIgnoreCaseContaining(String profileName);
}
