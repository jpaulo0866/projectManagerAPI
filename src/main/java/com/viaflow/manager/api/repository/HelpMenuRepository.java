package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.help.HelpMenu;

@Repository
public interface HelpMenuRepository extends MongoRepository<HelpMenu, String>{
	HelpMenu findByComponentComponentId(String componentId);


}
