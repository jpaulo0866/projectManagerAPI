package com.viaflow.manager.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.user.Profile;


@Service
public interface ProfileService extends BaseService<Profile> {
	List<Profile> findByName(String name);
}
