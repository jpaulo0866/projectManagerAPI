package com.viaflow.manager.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.user.Profile;

import com.viaflow.manager.api.repository.ProfileRespository;
import com.viaflow.manager.api.service.ProfileService;

@Service
public class ProfileServiceImpl extends BaseServiceImpl<Profile, ProfileRespository> implements ProfileService {

	@Autowired
	private ProfileRespository profileRepository;
	
	@Override
	protected ProfileRespository getRepo() {
		return this.profileRepository;
	}

	@Override
	public List<Profile> findByName(String name) {
		return this.getRepo().findAllByProfileNameIgnoreCaseContaining(name);
	}
	
}
